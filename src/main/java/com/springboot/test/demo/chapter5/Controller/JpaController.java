package com.springboot.test.demo.chapter5.Controller;

import com.springboot.test.demo.chapter5.dao.JpaUserRepository;
import com.springboot.test.demo.chapter5.pojo.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private JpaUserRepository jpaUserRepository = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public UserJpa getUser(Long id) {
        UserJpa user = jpaUserRepository.findById(id).get();
        return user;
//        return null;
    }


}
