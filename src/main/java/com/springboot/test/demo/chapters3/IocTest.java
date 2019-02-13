package com.springboot.test.demo.chapters3;

import com.springboot.test.demo.chapters3.config.AppConfig;
import com.springboot.test.demo.chapters3.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IocTest {
    private static Logger log = Logger.getLogger(IocTest.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
//        log.info(user.getId());
        System.out.println(user.getId());

    }
}
