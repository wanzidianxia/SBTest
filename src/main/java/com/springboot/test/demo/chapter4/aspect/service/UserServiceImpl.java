package com.springboot.test.demo.chapter4.aspect.service;

import com.springboot.test.demo.chapter4.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查用户参数是否为空......");
        }
        System.out.println("id=" + user.getId());
        System.out.print("username=" + user.getUserName());
        System.out.println("note=" + user.getNote());

    }
}

