package com.springboot.test.demo.chapter5.service;

import com.springboot.test.demo.chapter5.pojo.UserJpa;

import java.util.List;

public interface JdbcTmplUserService {
     UserJpa getUser(Long id);

     UserJpa getUser2(Long id);

     UserJpa getUser3(Long id);

     List<UserJpa> findUsers(String userName, String note);

     int insertUser(UserJpa user);

     int updateUser(UserJpa user);

     int deleteUser(Long id);

}
