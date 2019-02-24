package com.easyiot.easylinker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame {
    public SnakeGame() {

    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        SnakeGame sg = new SnakeGame();
        sg.init(jf, 800, 600);
        final SnakePanel sp = new SnakePanel();
        //调用初始化地图的方法
        sp.initMap();
        //调用初始化蛇的方法
        sp.initSnake();
        //调用生成食物的方法
        sp.createFood();

        sp.move();

        jf.add(sp);
        jf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                char ch = e.getKeyChar();
                System.out.println("keyCode=" + keyCode + ",keyChar=" + ch);
                //得到蛇头的坐标
                Point snakeHead = sp.snake.getFirst();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        //sp.snake.addFirst(new Point(snakeHead.x-1,snakeHead.y));
                        sp.setDirection(SnakePanel.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        sp.setDirection(SnakePanel.RIGHT);
                    case 102: //小键盘的数字6
                    case 54:  //大键盘的数字6

                        break;
                    case KeyEvent.VK_UP:
                        sp.setDirection(SnakePanel.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        sp.setDirection(SnakePanel.DOWN);
                        break;
                    default:
                        break;
                }
                //假定对应的宽度为40列,对应的是横轴的坐标x
                final int X_WIDTH = 40;
                //假定对应的高度为30列,对应的是纵轴的坐标y
                final int Y_HEIGHT = 30;
                //撞墙了，游戏结束-----如果是 X_WIDTH-1或者 == 0，则蛇会进入墙壁，不允许！
                if (snakeHead.x == X_WIDTH - 2 || snakeHead.x == 1 || snakeHead.y == Y_HEIGHT - 2 || snakeHead.y == 1) {
                    String message = "GameOver!";
                    JOptionPane.showMessageDialog(sp, message);
                    System.exit(0);
                } else {
                    sp.move();
                }

            }
        });
    }

    public void init(JFrame frame, int formWidth, int formHeight) {
        //设置当前窗体可见,默认不可见
        frame.setVisible(true);
        //int formWidth = 300;
        //int formHeight = 200;
        //设置当前窗体的宽和高
        frame.setSize(formWidth + 14, formHeight + 35);
        frame.setTitle("我的贪食蛇....");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //通过Dimension类的对象dim可以获取到屏幕的宽和高
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        System.out.println("当前屏幕的分辨率为:" + screenWidth + "*" + screenHeight);


        int x = (screenWidth - formWidth) / 2;
        int y = (screenHeight - formHeight) / 2;
        ;
        //设置当前窗体出现在窗口中坐标位置,即x轴的坐标值和y轴的坐标值
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class SnakePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    int x_width = 40;
    int y_height = 30;

    //假定对应的宽度为40列,对应的是横轴的坐标x
    public static final int X_WIDTH = 40;
    //假定对应的高度为30列,对应的是纵轴的坐标y
    public static final int Y_HEIGHT = 30;
    /*
     *
     * 定义一个30*40二维数组 ,表示有30行40列
     * 其中行对应的是y轴的坐标值
     * 列对应的是x轴的坐标值
     */
    boolean[][] map = new boolean[Y_HEIGHT][X_WIDTH];

    /*
     * 初始化地图的方法:
     * 第一行、最后一行、第一列、最后一列表示游戏中的墙壁
     * [1,28]*[1,38]表示的是蛇活动的地图
     * 如果是墙壁则赋值为true，否则活动区域为false
     *
     */
    void initMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || i == map.length - 1 || j == 0 || j == map[i].length - 1)
                    map[i][j] = true;
                //else
                //    map[i][j] = false;
            }
        }
    }

    LinkedList<Point> snake = new LinkedList<Point>();

    /*
     * 绘制蛇以及保存蛇的坐标值
     * 假定：
     * 蛇的整个长度为3,蛇头一节,蛇身2节
     * 蛇头水平垂直居中显示————即横轴40/2-1,纵轴30/2-1
     *
     * 初始化蛇的坐标值的方法并将坐标信息保存在LinkedList集合中
     */
    void initSnake() {
        int x = X_WIDTH / 2 - 1; //19  //水平居中的横轴坐标x
        int y = Y_HEIGHT / 2 - 1; //14 //垂直居中的纵轴坐标y
        for (int i = 0; i < 3; i++) {
            snake.add(new Point(x - i, y));
        }
    }


    Point food;  //食物的坐标

    /**
     * 随机生成食物的坐标
     * 规则:
     * 1.食物不能在墙壁上
     * 随机生成的食物坐标的取值范围 [1,38] * [1,28]
     * 也就是x坐标值取值为 [1,38]之间
     * y坐标值取值为[1,28]之间
     * <p>
     * Math.ramdom()
     * 或者
     * Random random = new Random();
     * random.nextInt(int value)
     */
    public void createFood() {
        Random random = new Random();

        while (true) {
            int x = random.nextInt(X_WIDTH);
            int y = random.nextInt(Y_HEIGHT);
            System.out.println("x:" + x + ",y:" + y);
            //x表示的是二维数组中的列,y表示的是二维数组中的行,所以在二维数组中先传y在传x,即先行后列
            if (!map[y][x]) {
                food = new Point(x, y);
                break;
            }
        }

    }

    //自定义上下左右四个方向的常量
    public static final int LEFT = 1;
    public static final int RIGHT = -1;
    public static final int UP = 2;
    public static final int DOWN = -2;


    //假定蛇向右运动
    int currentDirection = RIGHT;

    /*
     * 如果运动方向和当前所对应的方向相加等于0
     * 则认为蛇在玩180度掉头，不允许,给出相应的
     * 提示，否则就将当前方向换成运动方向
     *
     *
     */
    public void setDirection(int newDirection) {
        System.out.println("--------->newDirection=" + newDirection);
        if (currentDirection + newDirection == 0) {
            String message = "初级用户不能玩180度掉头!";
            System.out.println(message);
            JOptionPane.showMessageDialog(this, message, "警告", JOptionPane.WARNING_MESSAGE);
        } else
            this.currentDirection = newDirection;

    }

    /*
     * 通过键盘按下上、下、左、右键
     * 就将蛇移动的方向进行了设定,之后就应该根据对应的移动方向移动
     * 往左:横轴坐标做减法操作,纵轴不变
     * 往右:横轴坐标做加法操作,纵轴不变
     * 往上:纵轴坐标做减法操作,横轴不变
     * 往下:纵轴坐标做加法操作,横轴不变
     *
     * 注意:不要用--或++
     *
     */
    public void move() {
        System.out.println("----------move()------------");
        Point snakeHead = snake.getFirst();
        switch (currentDirection) {
            case LEFT:
                snake.addFirst(new Point(snakeHead.x - 1, snakeHead.y));
                break;
            case RIGHT:
                snake.addFirst(new Point(snakeHead.x + 1, snakeHead.y));
                break;
            case UP:
                snake.addFirst(new Point(snakeHead.x, snakeHead.y - 1));
                break;
            case DOWN:
                snake.addFirst(new Point(snakeHead.x, snakeHead.y + 1));
                break;
            default:
                break;
        }

        /*
         * 蛇只有在吃到食物的时候才会增长一节,否则蛇长保持不变
         * ，但是由于蛇在移动过程中坐标一直都保存在LinkedList
         * 所以在没有吃到食物的时候应该将蛇身的最后一节移除掉
         * 可以通过LinkedList集合中的removeLast()完成
         *
         *
         */
        if (eatFood()) {
            createFood();//再次生成食物

        } else {//移除最后的尾巴
            snake.removeLast();
        }

        repaint();
    }

    /*
     * 判断蛇吃到食物的方法
     *
     */


    public boolean eatFood() {
        Point snakeHead = snake.getFirst();
        boolean isEat = false;
        //如果吃到了食物
        if (snakeHead.x == food.x && snakeHead.y == food.y) {
            isEat = true;
        }

        return isEat;
    }


    //地图中的最小单元格为20*20的正方形
    int cell_width = 20;  //当前单元格的宽
    int cell_height = 20;  //当前单元格的高

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //外层循环控制的是行数即当前坐标的纵坐标y
        for (int i = 0; i < map.length; i++) {
            //内层循环控制的是列数即当前坐标的横坐标x
            for (int j = 0; j < map[i].length; j++) {
                //如果是墙壁，则设置墙壁的颜色为深灰色
                if (map[i][j])
                    g.setColor(Color.DARK_GRAY);
                else
                    //如果是活动区域则设置为白色
                    g.setColor(Color.WHITE);
                //在对应的panel上绘制30*40（即1200个）正方形(20*20)的单元格从而构成我们的游戏界面
                g.fill3DRect(j * cell_width, i * cell_height, cell_width, cell_height, true);
            }
        }
        //绘制蛇头
        Point snakeHead = snake.getFirst();
        g.setColor(Color.RED);
        g.fill3DRect(snakeHead.x * cell_width, snakeHead.y * cell_height, cell_width, cell_height, true);
        //绘制蛇身
        g.setColor(Color.GREEN);
        for (int i = 1; i < snake.size(); i++) {
            Point snakeBody = snake.get(i);
            g.fill3DRect(snakeBody.x * cell_width, snakeBody.y * cell_height, cell_width, cell_height, true);
        }

        //绘制食物
        g.setColor(Color.PINK);
        g.fill3DRect(food.x * cell_width, food.y * cell_height, cell_width, cell_height, true);
    }


}
