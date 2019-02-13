package com.springboot.test.demo.chapters3.service;

import com.springboot.test.demo.chapters3.pojo.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    public void printUser(User user) {
        System.out.println("编号：" + user.getId());
        System.out.println("用户姓名：" + user.getUserName());
        System.out.println("备注：" + user.getNote());
    }
}
