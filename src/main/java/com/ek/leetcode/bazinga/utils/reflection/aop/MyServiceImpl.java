package com.ek.leetcode.bazinga.utils.reflection.aop;

import org.apache.log4j.Logger;

public class MyServiceImpl implements MyService {

    private Logger logger = Logger.getLogger(MyServiceImpl.class);

    public String sayHello(String name, String country) {

        return "Hello " + name + " from " + country;
    }

    public String sayHi() {

        return "Hi some one!";
    }
}
