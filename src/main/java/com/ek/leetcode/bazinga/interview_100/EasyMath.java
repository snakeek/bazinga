package com.ek.leetcode.bazinga.interview_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2021
 * FileName: EasyMath
 * Author:   renyc
 * Date:     2021/2/26 2:33 下午
 * Description: 1
 */
public class EasyMath {
    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        list.stream().forEach(System.out::println);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int three = 0;
        int five = 0;
        for (int i = 1; i <= n; i++) {
            three = i % 3;
            five = i % 5;
            if (three == 0 && five == 0 && i != 0) {
                list.add("FizzBuzz");
            } else if (three == 0) {
                list.add("Fizz");
            } else if (five == 0) {
                list.add("Buzz");
            } else {
                list.add("" + i);
            }
        }
        return list;
    }
}