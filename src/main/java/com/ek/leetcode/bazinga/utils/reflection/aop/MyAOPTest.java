package com.ek.leetcode.bazinga.utils.reflection.aop;

public class MyAOPTest {

    public static void main(String[] args) throws Exception {

        MyService my = LogInvoHandler.getProxyInstance(MyServiceImpl.class);
        my.sayHello("snakeek", "china");
        my.sayHi();

        System.out.println("=============================================");

        WorkService ws = LogInvoHandler.getProxyInstance(WorkServiceImpl.class);
        ws.work();
        ws.sleep();

        System.out.println("=============================================");
    }
}
