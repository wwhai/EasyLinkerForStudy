package com.easyiot.easylinker.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms
public class AMQconfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("test");
    }
}
