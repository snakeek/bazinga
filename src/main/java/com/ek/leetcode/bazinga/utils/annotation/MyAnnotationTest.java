package com.ek.leetcode.bazinga.utils.annotation;

import java.lang.reflect.Method;

public class MyAnnotationTest {

    public static void main(String[] args) throws Exception {

        MyHello hello = new MyHello();
        Method[] methods = hello.getClass().getDeclaredMethods();

        for (Method m : methods) {

            System.out.println("______Method name : " + m.getName());
            MyFirtst temp = null;
            if ((temp = m.getAnnotation(MyFirtst.class)) != null) {
                m.invoke(hello, temp.paramValue());
            } else {
                m.invoke(hello, "Test Rose");
            }
        }
    }
}
