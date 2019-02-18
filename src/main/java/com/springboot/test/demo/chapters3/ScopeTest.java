package com.springboot.test.demo.chapters3;

import com.springboot.test.demo.chapters3.config.AppConfig;
import com.springboot.test.demo.chapters3.scope.pojo.ScopeBean;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
    private static Logger log = Logger.getLogger(IocTest.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBean1 == scopeBean2);
    }
}
