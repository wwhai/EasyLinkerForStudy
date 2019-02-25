package com.easyiot.easylinker.service;

import com.easyiot.easylinker.dao.SimpleHttpClientDAO;
import com.easyiot.easylinker.model.SimpleHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SimpleHttpClientService {
    private final SimpleHttpClientDAO dao;

    @Autowired
    public SimpleHttpClientService(SimpleHttpClientDAO dao) {
        this.dao = dao;
    }


    /**
     * 根据id查找当前Model
     *
     * @param id
     * @return
     */

    public SimpleHttpClient findOneById(long id) {
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
     * @param SimpleHttpClient
     */

    public void save(SimpleHttpClient SimpleHttpClient) {
        dao.save(SimpleHttpClient);
    }

    /**
     * 更新Model
     *
     * @param SimpleHttpClient
     */

    public void update(SimpleHttpClient SimpleHttpClient) {
        dao.save(SimpleHttpClient);
    }

    /**
     * 分页展示
     *
     * @param pageable
     * @return
     */

    public Page<SimpleHttpClient> list(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
