package com.easyiot.easylinker.dao;

import com.easyiot.easylinker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findTopByUsernameAndPassword(String username, String password);
    User findTopByEmailAndPassword(String email, String password);

}
