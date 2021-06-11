package com.ek.leetcode.bazinga.utils.reflection.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class LogInvoHandler implements InvocationHandler {

    private Object target;
    private Object proxy;

    private static HashMap<Class<?>, LogInvoHandler> invoHandlers = new HashMap<Class<?>, LogInvoHandler>();

    private LogInvoHandler() {

    }

    public synchronized static <T> T getProxyInstance(Class<T> clazz) {

        LogInvoHandler handler = invoHandlers.get(clazz);

        if (null == handler) {

            handler = new LogInvoHandler();
            try {
                T tar = clazz.newInstance();
                handler.setTarget(tar);
                handler.setProxy(Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                        tar.getClass().getInterfaces(), handler));
            } catch (Exception e) {
                e.printStackTrace();
            }

            invoHandlers.put(clazz, handler);
        }

        return (T) handler.getProxy();
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        //????????
        Object result = method.invoke(target, args);

        //??????
        System.out.println("____invoke method : " + method.getName()
                + "; \n args : " + (null == args ? "null" : Arrays.asList(args).toString())
                + "; \n return : " + result);

        return result;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }
}
