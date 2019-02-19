package com.easyiot.easylinker.dao;

import com.easyiot.easylinker.model.MqttClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MqttClientDAO extends JpaRepository<MqttClient, Long> {

}
