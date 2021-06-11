package com.ek.leetcode.bazinga.pattern.proxy.jdk;

import lombok.Data;

/**
 * Created by snakeek on 2018/5/5.
 */
@Data
public class Someone implements Person {

    private int sex = 1;
    private String name = "someName";

    @Override
    public void buy() {
        System.out.println("name is " + name + "  and sex is " + sex);
    }

    @Override
    public String toString() {
        return "sss";
    }
}
