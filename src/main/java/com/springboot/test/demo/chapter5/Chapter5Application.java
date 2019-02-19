package com.springboot.test.demo.chapter5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.springboot.test.demo.chapter5"})
@EnableJpaRepositories(basePackages = "com.springboot.test.demo.chapter5.dao")
@EntityScan(basePackages = "com.springboot.test.demo.chapter5.pojo")
public class Chapter5Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class, args);
    }

}