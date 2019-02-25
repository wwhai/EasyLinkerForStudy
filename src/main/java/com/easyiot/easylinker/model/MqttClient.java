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
    private Long id;

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
    private String topic = "/mqtt/client/"+getClientId();

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

    private String type="VALUE";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceDescribe() {
        return deviceDescribe;
    }

    public void setDeviceDescribe(String deviceDescribe) {
        this.deviceDescribe = deviceDescribe;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(String lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


}
