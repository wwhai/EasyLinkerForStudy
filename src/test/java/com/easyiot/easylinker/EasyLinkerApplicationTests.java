package com.easyiot.easylinker;

import com.easyiot.easylinker.model.MqttClient;
import com.easyiot.easylinker.model.UserMessage;
import com.easyiot.easylinker.service.MqttClientService;
import com.easyiot.easylinker.service.UserMessageService;
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

    @Test
    public void contextLoads() {
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

