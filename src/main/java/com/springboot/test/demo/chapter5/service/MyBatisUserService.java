package com.springboot.test.demo.chapter5.service;

import com.springboot.test.demo.chapter5.pojo.User;

public interface MyBatisUserService {
    User getUser(Long id);
}
