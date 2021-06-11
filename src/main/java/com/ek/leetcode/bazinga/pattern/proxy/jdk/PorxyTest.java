package com.ek.leetcode.bazinga.pattern.proxy.jdk;

/**
 * Created by snakeek on 2018/5/5.
 */
public class PorxyTest {
    public static void main(String[] args) throws Exception {
        Person proxyPerson = (Person) new ProxyPeople().getInstance(new Someone());
        proxyPerson.buy();
        Person anotherPerson = new Someone();
        System.out.print("aa");
    }
}
