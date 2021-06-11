package com.ek.leetcode.bazinga.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by snakeek on 2018/5/5.
 */
public class ProxyPeople implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target) throws Exception {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy called!");
        this.target.buy();
        return null;
    }
}
