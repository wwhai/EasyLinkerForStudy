package com.easyiot.easylinker;

import com.easyiot.easylinker.model.MqttClient;
import com.easyiot.easylinker.model.User;
import com.easyiot.easylinker.model.UserMessage;
import com.easyiot.easylinker.service.MqttClientService;
import com.easyiot.easylinker.service.UserMessageService;
import com.easyiot.easylinker.service.UserService;
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
        for (int i = 0; i < 25; i++) {
            MqttClient mqttClient = new MqttClient();
            mqttClientService.save(mqttClient);

        }


        for (int i = 0; i < 35; i++) {
            UserMessage userMessage = new UserMessage();
            userMessage.setUserId(1L);
            userMessage.setTitle("测试标题" + i);
            userMessage.setContent("测试消息" + i);
            userMessageService.save(userMessage);

        }

    }

}

