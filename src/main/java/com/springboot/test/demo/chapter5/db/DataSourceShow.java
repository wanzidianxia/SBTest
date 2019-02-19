package com.springboot.test.demo.chapter5.db;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
//实现Spring Bean 生命周期接口 ApplicationContextAware
public class DataSourceShow implements ApplicationContextAware {
    ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("-----------------------------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("-----------------------------------");

    }
}
