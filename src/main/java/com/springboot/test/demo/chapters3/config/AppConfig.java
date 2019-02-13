package com.springboot.test.demo.chapters3.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(value = "com.springboot.test.demo.chapters3.*",
        excludeFilters = {@ComponentScan.Filter(classes = {Service.class})})
public class AppConfig {
    /*
    public User initUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("zhangsan");
        user.setNote("notecontent");
        return user;
    }
    */
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/guns");
        props.setProperty("username", "root");
        props.setProperty("password", "");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }
}
