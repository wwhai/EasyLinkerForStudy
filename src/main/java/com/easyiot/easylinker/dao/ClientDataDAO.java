package com.easyiot.easylinker.dao;

import com.easyiot.easylinker.model.ClientData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDataDAO extends JpaRepository<ClientData, Long> {


    List<ClientData> findAllByClientId(String clientId, Pageable pageable);
}
