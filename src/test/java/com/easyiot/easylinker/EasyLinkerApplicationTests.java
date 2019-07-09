package com.easyiot.easylinker;

import com.easyiot.easylinker.model.*;
import com.easyiot.easylinker.service.*;
import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyLinkerApplicationTests {
    @Autowired
    MqttClientService mqttClientService;
    @Autowired
    UserMessageService userMessageService;

    @Autowired
    UserService userService;

    @Autowired
    ClientDataService clientDataService;
    @Autowired
    SimpleHttpClientService simpleHttpClientService;

    @Test
    public void testJMX() throws IOException, MalformedObjectNameException {
        String url = "service:jmx:rmi:///jndi/rmi://localhost:11099/jmxrmi";
        JMXServiceURL urls = new JMXServiceURL(url);
        JMXConnector connector = JMXConnectorFactory.connect(urls, null);
        connector.connect();
        MBeanServerConnection conn = connector.getMBeanServerConnection();
        //这里brokerName的b要小些，大写会报错
        ObjectName name = new ObjectName("org.apache.activemq:brokerName=localhost,type=Broker");
        BrokerViewMBean mBean = (BrokerViewMBean) MBeanServerInvocationHandler.newProxyInstance(conn, name, BrokerViewMBean.class, true);
        for (ObjectName na : mBean.getTopics()) {// mBean.getQueues() 获取点对点的队列       mBean.getTopics() 获取订阅模式的队列
            QueueViewMBean queueBean = (QueueViewMBean)
                    MBeanServerInvocationHandler.newProxyInstance(conn, na, QueueViewMBean.class, true);
            System.out.println("******************************");
            System.out.println("队列的名称：" + queueBean.getName());
            System.out.println("队列中剩余的消息数：" + queueBean.getQueueSize());
            System.out.println("消费者数：" + queueBean.getConsumerCount());
            System.out.println("出队列的数量：" + queueBean.getDequeueCount());

        }
    }
    @Test
    public void contextLoads() {
        User user = new User();
        user.setNickname("大牛牛");
        user.setPassword("123456");
        user.setEmail("123@qq.com");
        user.setRoles("ADMIN");
        user.setUsername("admin");
        user.setToken("token");
        userService.save(user);
        /**
         * 添加测试 MQTT客户端数据
         */
        for (int i = 0; i < 25; i++) {
            MqttClient mqttClient = new MqttClient();
            mqttClientService.save(mqttClient);
            for (int j = 0; j < 23; j++) {
                ClientData clientData = new ClientData();
                clientData.setClientId(mqttClient.getClientId());
                clientData.setValue("{\"h\":55,\"c\":27,\"f\":80.5999984741211,\"cc\":21.985000610351562,\"ff\":81.923568725585938}\n");
                clientDataService.save(clientData);
            }

        }

        /**
         * 添加测试 HTTP 客户端数据
         */
        for (int i = 0; i < 25; i++) {
            SimpleHttpClient simpleHttpClient = new SimpleHttpClient();
            simpleHttpClientService.save(simpleHttpClient);
            for (int j = 0; j < 23; j++) {
                ClientData clientData = new ClientData();
                clientData.setClientId(simpleHttpClient.getClientId());
                clientData.setValue("{\"h\":55,\"c\":27,\"f\":80.5999984741211,\"cc\":21.985000610351562,\"ff\":81.923568725585938}\n");
                clientDataService.save(clientData);
            }

        }


        for (int i = 0; i < 35; i++) {
            UserMessage userMessage = new UserMessage();
            userMessage.setUserId(1L);
            userMessage.setTitle("测试标题" + i);
            userMessage.setContent("测试消息" + i);
            userMessageService.save(userMessage);

        }

    }

    /**
     * {"h":55,"c":27,"f":80.5999984741211,"cc":21.985000610351562,"ff":81.923568725585938}
     */

}

