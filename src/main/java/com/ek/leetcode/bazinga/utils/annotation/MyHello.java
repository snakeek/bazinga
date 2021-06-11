package com.ek.leetcode.bazinga.utils.annotation;

public class MyHello {

    public void sayHello(String name) {

        System.out.println("Hello : " + name);
    }

    @MyFirtst(paramValue = "Test User")
    public void sayHelloAnnotation(String name) {

        System.out.println("Hello : " + name);
    }

    @MyFirtst
    public void sayHelloDefault(String name) {

        System.out.println("Hello : " + name);
    }
}
