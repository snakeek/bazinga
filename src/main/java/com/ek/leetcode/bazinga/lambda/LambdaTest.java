package com.ek.leetcode.bazinga.lambda;

import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;

import java.util.List;

/**
 * Created by snakeek on 2018/10/29.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        list.forEach(System.out::println);

        list.forEach(i -> {
            System.out.println(String.valueOf(Integer.parseInt(i) * 3));
        });

        //multi thread
        new Thread(() -> System.out.println("java8 lambda in a thread!")).start();

        String a = null;
        if (a instanceof String) {
            System.out.println("null is string instance!");
        } else if (a instanceof Object) {
            System.out.println("null is object instance!");
        } else {
            System.out.println("just null");
        }
    }
}
