package com.springboot.test.demo.chapter4.proxy;

import com.springboot.test.demo.chapter4.intercept.Interceptor;
import com.springboot.test.demo.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyBean implements InvocationHandler {
    private Object target = null;
    private Interceptor interceptor = null;

    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理的对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target, method, args);
        Object retObj = null;
        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }

        } catch (Exception e) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
