package com.ek.leetcode.bazinga.lambda;

import java.util.function.Function;

/**
 * Created by snakeek on 2018/10/29.
 */
public class MyFunctionInterfaceTest {
    public static Integer convert(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        Integer value = convert("28", str -> Integer.parseInt(str));
        if (value instanceof Integer) {
            System.out.println("convert to Integer!");
        } else {
            System.out.println("not Integer!");
        }
    }
}
