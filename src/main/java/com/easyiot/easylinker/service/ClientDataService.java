package com.easyiot.easylinker.service;

import com.easyiot.easylinker.dao.ClientDataDAO;
import com.easyiot.easylinker.model.ClientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientDataService {
    private final ClientDataDAO dao;

    @Autowired
    public ClientDataService(ClientDataDAO dao) {
        this.dao = dao;
    }


    /**
     * 根据id查找当前Model
     *
     * @param id
     * @return
     */

    public ClientData findOneById(long id) {
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
     * @param ClientData
     */

    public void save(ClientData ClientData) {
        dao.save(ClientData);
    }

    /**
     * 更新Model
     *
     * @param ClientData
     */

    public void update(ClientData ClientData) {
        dao.save(ClientData);
    }

    /**
     * 分页展示
     *
     * @param pageable
     * @return
     */

    public Page<ClientData> list(Pageable pageable) {
        return dao.findAll(pageable);
    }


    public Page<ClientData> list(String clientId, Pageable pageable) {
        return dao.findAll(pageable);
    }


}
