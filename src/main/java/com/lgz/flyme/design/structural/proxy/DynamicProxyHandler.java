package com.lgz.flyme.design.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liguangzhi
 * @date 2020/11/13
 */
public class DynamicProxyHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object proxiedObject;



    public DynamicProxyHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
        ClassLoader classLoader = this.proxiedObject.getClass().getClassLoader();
        Class<?>[] interfaces = this.proxiedObject.getClass().getInterfaces();

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("日志开始");
        Object result = method.invoke(proxiedObject, args);
        System.out.println("日志结束");
        return result;

    }
}
