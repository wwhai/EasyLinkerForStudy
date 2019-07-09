package com.easyiot.easylinker.mqttServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan("com.easyiot.easylinker.mqttServer.MqttServer")
//@Component
public class MqttServer {
    /**
     * 消息接收函数，处理接收到的消息
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> System.out.println("###"+message.getPayload());
    }



    @MessagingGateway(defaultRequestChannel = "mqttOutputChanel" )
    @Service
    public interface MqttGateway{
        /**
         * 发送至默认topic
         * @param payload
         */
        void sendMessage(String payload);

        /**
         * 发送至指定topic
         * @param topic
         * @param payload
         */
        void sendMessage(@Header(MqttHeaders.TOPIC) String topic,String payload);

        /**
         * 用指定QOS发送至指定topic
         * @param topic
         * @param qos
         * @param payload
         */
        void sendMessage(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
    }
}
