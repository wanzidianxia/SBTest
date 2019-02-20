package com.springboot.test.demo.chapter5.service;

import com.springboot.test.demo.chapter5.dao.MyBatisUserDao;
import com.springboot.test.demo.chapter5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    private MyBatisUserDao myBatisUserDao = null;

    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
