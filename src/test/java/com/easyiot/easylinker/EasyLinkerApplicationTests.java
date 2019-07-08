package com.easyiot.easylinker;

import com.easyiot.easylinker.model.*;
import com.easyiot.easylinker.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

