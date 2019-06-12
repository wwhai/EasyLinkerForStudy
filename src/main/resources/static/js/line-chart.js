document.write('<script src="/js/echarts.min.js"></script>')
document.write('<script src="/js/walden.js"></script>')
$(document).ready(()=>{
    createLineChart() //line-chart
})


/**
 * 创建折线图
 */
function createLineChart() {
    let myChart = echarts.init(document.getElementById('line-chart'), 'walden')
    let option = {
        title: {
            text: '温度数据'
        },
        tooltip: {
            trigger: 'axis'
        },
        toolbox: {
            feature: {
                saveAsImage: {},
                dataView: {},
                magicType: {
                    type: ['line', 'bar', 'tiled', 'stack']
                },
                restore: {}
            },
            right: '20'
        },

        grid: {
            left: '5%',
            right: '5%',
        },

        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                splitLine: {
                    show: false
                },
                data: ['11:22:33', '11:32:33', '11:42:33', '11:52:33', '12:12:33', '12:22:33', '12:32:33']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '湿度',
                type: 'line',
                stack: '总量',
                smooth: true,
                // smoothMonotone: 'x',
                symbol: 'none',
                data: [120, 232, 301, 134, 90, 230, 270]
            },
            {
                name: '华氏温度',
                type: 'line',
                stack: '总量',
                smooth: true,
                symbol: 'none',
                data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
                name: '摄氏度温湿度指数',
                type: 'line',
                smooth: true,
                stack: '总量',
                symbol: 'none',
                data: [150, 232, 201, 154, 190, 330, 410]
            },
            {
                name: '华氏度温湿度指数',
                type: 'line',
                stack: '总量',
                smooth: true,
                symbol: 'none',
                data: [320, 332, 301, 334, 390, 330, 320]
            }
        ]
    }
    if (option && typeof option === 'object') {
        myChart.setOption(option, true)
    }
}