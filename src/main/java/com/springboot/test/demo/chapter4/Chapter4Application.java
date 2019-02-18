package com.springboot.test.demo.chapter4;

import com.springboot.test.demo.chapter4.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.springboot.test.demo.chapter4.aspect"})
public class Chapter4Application {
    //定义切面
    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    //启动切面
    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class, args);
    }

}
