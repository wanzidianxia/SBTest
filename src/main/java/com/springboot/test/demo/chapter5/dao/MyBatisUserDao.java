package com.springboot.test.demo.chapter5.dao;

import com.springboot.test.demo.chapter5.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {
    User getUser(Long id);
}
