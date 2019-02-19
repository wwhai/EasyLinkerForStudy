package com.easyiot.easylinker.service;

import com.easyiot.easylinker.dao.MqttClientDAO;
import com.easyiot.easylinker.model.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MqttClientService {
    private final MqttClientDAO dao;

    @Autowired
    public MqttClientService(MqttClientDAO dao) {
        this.dao = dao;
    }


    /**
     * 根据id查找当前Model
     *
     * @param id
     * @return
     */

    public MqttClient findOneById(long id) {
        return dao.findById(id).get();

    }

    /**
     * 根据id删除当前Model
     *
     * @param id
     */

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */

    public void deleteByIds(long[] ids) {
        for (long id : ids) {
            dao.deleteById(id);

        }

    }


    /**
     * 在数据库存储当前 Model
     *
     * @param MqttClient
     */

    public void save(MqttClient MqttClient) {
        dao.save(MqttClient);
    }

    /**
     * 更新Model
     *
     * @param MqttClient
     */

    public void update(MqttClient MqttClient) {
        dao.save(MqttClient);
    }

    /**
     * 分页展示
     *
     * @param pageable
     * @return
     */

    public Page<MqttClient> list(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
