package com.springboot.test.demo.chapter4.aspect.validator;

import com.springboot.test.demo.chapter4.pojo.User;

public interface UserValidator {
    boolean validate(User user);
}
