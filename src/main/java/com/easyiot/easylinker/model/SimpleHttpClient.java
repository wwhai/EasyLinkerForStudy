package com.easyiot.easylinker.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * 简单的HTTP 设备
 */
@Data
@Entity
public class SimpleHttpClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *
     */
    private Long id;

    /**
     *
     */

    private String deviceDescribe = "Http Client";

    /**
     *
     */
    private String ipAddress = "localhost";

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
}
