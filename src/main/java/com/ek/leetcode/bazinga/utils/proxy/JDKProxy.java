package com.ek.leetcode.bazinga.utils.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;

/**
 * Created by snakeek on 2017/7/8.
 */
public class JDKProxy {

    public static Object getProxyObject(final Object obj) {
        //JDK动态代理必须要接口
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o;
                System.out.println("proxy something! ");
                o = method.invoke(obj, args);
                System.out.println(" [" + Calendar.getInstance().get(Calendar.HOUR) + ":"

                        + Calendar.getInstance().get(Calendar.MINUTE) + " "

                        + Calendar.getInstance().get(Calendar.SECOND) + "]");
                return o;
            }
        });
    }
}
