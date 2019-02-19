package com.easyiot.easylinker.service;

import com.easyiot.easylinker.dao.UserMessageDAO;
import com.easyiot.easylinker.model.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserMessageService {
    private final UserMessageDAO dao;

    @Autowired
    public UserMessageService(UserMessageDAO dao) {
        this.dao = dao;
    }


    /**
     * 根据id查找当前Model
     *
     * @param id
     * @return
     */

    public UserMessage findOneById(long id) {
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
     * @param UserMessage
     */

    public void save(UserMessage UserMessage) {
        dao.save(UserMessage);
    }

    /**
     * 更新Model
     *
     * @param UserMessage
     */

    public void update(UserMessage UserMessage) {
        dao.save(UserMessage);
    }

    /**
     * 分页展示
     *
     * @param pageable
     * @return
     */

    public Page<UserMessage> list(Pageable pageable) {
        return dao.findAll(pageable);
    }

    /**
     * 查找用户的消息
     *
     * @param userId
     * @param state
     * @param pageable
     * @return
     */
    public Page<UserMessage> list(Long userId, Integer state, Pageable pageable) {
        return dao.findAllByUserIdAndStateOrderByIdDesc(userId, state, pageable);

    }
}
