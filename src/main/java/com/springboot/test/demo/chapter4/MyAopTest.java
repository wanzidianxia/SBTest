package com.springboot.test.demo.chapter4;

import com.springboot.test.demo.chapter4.intercept.MyInterceptor;
import com.springboot.test.demo.chapter4.proxy.ProxyBean;
import com.springboot.test.demo.chapter4.service.HelloService;
import com.springboot.test.demo.chapter4.service.impl.HelloServiceImpl;
import com.springboot.test.demo.chapters3.config.AppConfig;
import com.springboot.test.demo.other.pojo.Squirrel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyAopTest {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("代理成功");
    }
}
