package com.ek.leetcode.bazinga.rpc.provider;

/**
 * Personal
 * Created by snakeek on 2017/7/11.
 */
public class HelloServiceimpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "Hi ~ " + name;
    }
}
