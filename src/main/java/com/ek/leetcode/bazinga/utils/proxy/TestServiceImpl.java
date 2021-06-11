package com.ek.leetcode.bazinga.utils.proxy;

import com.ek.utils.proxy.service.TestService;

/**
 * Created by snakeek on 2017/7/9.
 */
public class TestServiceImpl implements TestService {
    @Override
    public String saySomething(String something) {
        System.out.println(" this is : " + something);
        return something;
    }
}
