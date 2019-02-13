package com.springboot.test.demo.chapters3.pojo;

import com.springboot.test.demo.chapters3.pojo.definition.Animal;
import com.springboot.test.demo.chapters3.pojo.definition.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BussinessPerson implements Person, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private Animal anmal = null;

    //    public  BussinessPerson(@Autowired @Qualifier("cat") Animal animal){
//        this.anmal=animal;
//
//    }
    @Override
    public void service() {
        this.anmal.use();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.anmal = animal;
    }
    @Override
    public void setBeanName(String s) {
        System.out.println("【"+this.getClass().getSimpleName()
                +"】调用BeanNameAware的setBeanName");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()
                + "】调用BeanFactoryAware的setBeanFactory");

    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()
                +"】调用ApplicationContext的setApplicationContext");

    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()
                +"】调用InitializingBean的afterPropertiesSet");
    }
    @PostConstruct
    public  void  init(){
        System.out.println("【"+this.getClass().getSimpleName()
                +"】注解@PostConstruct定义的自定义初始化方法");
    }
    @PreDestroy
    public  void  destory1(){
        System.out.println("【"+this.getClass().getSimpleName()
                +"】注解@PreDestroy定义的自定义销毁方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()
                +"】DisposableBean方法");
    }




}
