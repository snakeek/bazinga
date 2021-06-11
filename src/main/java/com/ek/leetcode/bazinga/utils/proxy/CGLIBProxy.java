package com.ek.leetcode.bazinga.utils.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * Created by snakeek on 2017/7/9.
 */
public class CGLIBProxy {
    public static Object getProxyObject(Object c) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("proxy something!");
                methodProxy.invokeSuper(o, objects);
                System.out.println(" [" + Calendar.getInstance().get(Calendar.HOUR) + ":"

                        + Calendar.getInstance().get(Calendar.MINUTE) + " " + Calendar.getInstance().get(Calendar.SECOND)

                        + "]");
                return null;
            }
        });
        return enhancer.create();
    }
}
