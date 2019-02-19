package com.easyiot.easylinker.dao;

import com.easyiot.easylinker.model.UserMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMessageDAO extends JpaRepository<UserMessage, Long> {
    /**
     * 查找用户的消息
     * @param userId
     * @param state
     * @return
     */
    Page<UserMessage> findAllByUserIdAndState(Long userId, Integer state, Pageable pageable);

}
