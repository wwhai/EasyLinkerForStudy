package com.easyiot.easylinker.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.*;
import org.springframework.stereotype.Service;

@Configuration
@EnableConfigurationProperties
public class MqttConfig {

    /**
     * 从配置文件中获取相关属性
     */
    @Value("${mqtt.servers}")
    private String server;
    @Value("${mqtt.username}")
    private String username;
    @Value("${mqtt.password}")
    private String password;
    @Value("${mqtt.topic}")
    private String topic;
    private String clientId="spring_MQTT_Client";
    private String sendClientId="spring_MQTT_Send_Client";

    /**
     * 管理mqtt通道
     * @return
     */
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel mqttOutputChanel(){
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutputChanel")
    public MessageHandler outBound(){
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(sendClientId,clientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(topic);
        return messageHandler;
    }

    /**
     * 监听topic
     * @return MessageProducer
     */
    @Bean
    public MessageProducer inBound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(server, clientId,
                        topic);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    /**
     * 工厂模式设置连接属性
     * @return clientFactory
     */
    @Bean
    public MqttPahoClientFactory clientFactory(){
        DefaultMqttPahoClientFactory clientFactory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{server});
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        clientFactory.setConnectionOptions(options);
        return clientFactory;
    }


}
