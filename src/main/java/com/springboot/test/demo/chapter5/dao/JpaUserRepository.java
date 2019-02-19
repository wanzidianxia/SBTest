package com.springboot.test.demo.chapter5.dao;

import com.springboot.test.demo.chapter5.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User,Long> {
}
