package com.easyiot.easylinker.amq;


import javax.jms.Destination;

public interface AmqService {
    /**
     * 消息发送接口
     *
     * @param destination
     * 发送到目的消息队列
     * @param message
     * 消息体
     */
    void sendMessage(Destination destination , final String message);
    /**
     * 消息发送接口
     * 发送到配置队列
     * @param message
     * 消息体
     */
    void sendMessage(final String message);
}
