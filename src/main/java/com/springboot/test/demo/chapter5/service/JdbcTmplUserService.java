package com.springboot.test.demo.chapter5.service;

import com.springboot.test.demo.chapter5.pojo.User;

import java.util.List;

public interface JdbcTmplUserService {
     User getUser(Long id);

     User getUser2(Long id);

     User getUser3(Long id);

     List<User> findUsers(String userName,String note);

     int insertUser(User user);

     int updateUser(User user);

     int deleteUser(Long id);

}
