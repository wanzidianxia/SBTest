package com.springboot.test.demo.chapters3.config;

import com.springboot.test.demo.chapters3.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(value = "com.springboot.test.demo.chapters3.*", excludeFilters = {@ComponentScan.Filter(classes = {Service.class})})
@ImportResource(value = {"classpath:spring-other.xml"})
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
    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    @Profile("dev")
    public DataSource getDevDataSource() {
        System.out.println("getDevDaTaSource");
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/guns");
        props.setProperty("username", "root");
        props.setProperty("password", "root");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    @Profile("test")
    public DataSource getTestDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/test_guns");
        props.setProperty("username", "root");
        props.setProperty("password", "root");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }
}
