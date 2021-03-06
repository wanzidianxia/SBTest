package com.springboot.test.demo.chapter4.aspect;

import com.springboot.test.demo.chapter4.aspect.validator.UserValidator;
import com.springboot.test.demo.chapter4.aspect.validator.UserValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {
    @Pointcut("execution(* com.springboot.test.demo.chapter4.aspect.service.UserServiceImpl.printUser(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before......");
        jp.getArgs();
        jp.proceed();
        System.out.println("around after......");

    }

    @DeclareParents(value = "com.springboot.test.demo.chapter4.aspect.service.UserServiceImpl",
            defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

}
