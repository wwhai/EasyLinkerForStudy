package com.easyiot.easylinker.mqttServer;


import com.alibaba.fastjson.JSONObject;
import com.easyiot.easylinker.model.ClientData;
import com.easyiot.easylinker.model.MqttClient;
import com.easyiot.easylinker.service.ClientDataService;
import com.easyiot.easylinker.service.MqttClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Configuration
public class MqttServer {
    @Autowired
    MqttClientService mqttClientService;
    @Autowired
    ClientDataService clientDataService;
    /**
     * 消息接收函数，处理接收到的消息
     * @return
     */
    @Bean()
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        //init
        return message ->{ System.out.println("###"+message.getPayload()
                +"from: "+message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
            MqttClient mqttClient = new MqttClient();
            ClientData clientData = new ClientData();
            JSONObject jsonObject = JSONObject.parseObject(
                    message.getPayload().toString());
            clientData.setClientId(jsonObject.getString("clientId"));
            clientData.setValue(jsonObject.getString("value"));
            mqttClient.setClientId(jsonObject.getString("clientId"));
            mqttClient.setTopic(message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString());
            clientDataService.save(clientData);
            mqttClientService.update(mqttClient);


        };
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
