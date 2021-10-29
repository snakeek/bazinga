package com.ek.leetcode.bazinga.mybatis.how.plugin.work;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Copyright (C), 2019-2021
 * FileName: MyInvocationHandler
 * Author:   renyc
 * Date:     2021/10/14 4:49 下午
 * Description:
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    private Interceptor interceptor;

    public MyInvocationHandler(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////        System.out.println("some logic before invoke!");
//        for (Interceptor interceptor : interceptorList) {
//            interceptor.interceptor();
//        }
//        Object obj = method.invoke(target, args);
////        System.out.println("some logic after invode!");
//        return obj;
        Invocation invocation = new Invocation(target, method, args);
        return interceptor.interceptor(invocation);
    }

    public static Object warp(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new MyInvocationHandler(target, interceptor));
    }
}