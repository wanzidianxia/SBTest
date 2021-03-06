package com.springboot.test.demo.chapter4.aspect.Controller;


import com.springboot.test.demo.chapter4.aspect.service.UserService;
import com.springboot.test.demo.chapter4.aspect.validator.UserValidator;
import com.springboot.test.demo.chapter4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;


    }

    @RequestMapping("/vp")
    @ResponseBody
    public User validateAndPrint(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        UserValidator userValidator = (UserValidator) userService;
        if (userValidator.validate(user)) {
            userService.printUser(user);
        }

        return user;


    }


}
