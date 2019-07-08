package com.easyiot.easylinker.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

/**
 * 系统默认的用户
 */
@Data
@Entity
public class MqttClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *
     */
    private String id;

    private String name;

    /**
     *
     */
    private String username = "username";
    /**
     *
     */
    private String password = "password";
    /**
     *
     */

    private String deviceDescribe = "Mqtt Client";
    /**
     *
     */
    private boolean isOnline = false;
    /**
     *
     */
    private String ipAddress = "localhost";
    /**
     * 1 pub
     * 2 sub
     * 3 pub&&sub
     */
    private Integer access = 1;
    /**
     * topic= /mqtt/client/clientId
     */
    private String topic = "/mqtt/client/" + getClientId();

    /**
     *
     */

    private String lastOnlineTime = new Date().toString();
    /**
     * 经纬度
     */
    private String longitude = "0";
    private String latitude = "0";
    /**
     * UUID
     */
    private String clientId = UUID.randomUUID().toString().replace("-", "").toUpperCase();

    /**
     * 设备类型 分为
     * 1 value :比如温湿度
     * 2 switcher :开关类型，只有0 1 两个状态
     * 3 string :字符串型，比如聊天室
     */

    private String type = "VALUE";


}
