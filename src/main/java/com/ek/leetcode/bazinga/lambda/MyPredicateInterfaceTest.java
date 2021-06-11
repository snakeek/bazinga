package com.ek.leetcode.bazinga.lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by snakeek on 2018/10/29.
 */
public class MyPredicateInterfaceTest {
    public static List<String> filter(List<String> fruits, Predicate<String> predicate) {
        List<String> f = Lists.newArrayList();
        for (String s : fruits) {
            if (predicate.test(s)) {
                f.add(s);
            }
        }
        return f;
    }

    public static void main(String[] args) {
        List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFruit = filter(fruit, (f) -> f.length() == 2);
        newFruit.forEach(System.out::println);
    }
}
