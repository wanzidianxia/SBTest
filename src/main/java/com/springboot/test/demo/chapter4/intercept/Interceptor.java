package com.springboot.test.demo.chapter4.intercept;

import com.springboot.test.demo.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    //事前方法
    boolean before();

    //事后方法
    void after();

    //取代原有事件方法
    Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

    //事后返回方法，事件没有发生异常执行
    void afterReturning();

    //事后异常方法，当事件发生异常后执行
    void afterThrowing();

    //是否适用around方法取代原有方法
    boolean useAround();


}
