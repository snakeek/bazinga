package com.ek.leetcode.bazinga.basic;

import java.lang.reflect.Field;

/**
 * Personal
 * Created by snakeek on 2018/5/25.
 */
public class SwapInteger {
    public static void main(String[] args) throws Exception {
//        Integer a1= 1, a2 = 2;
//        System.out.println("a is " + a1 + " and b is " + a2);
//        swap(a1, a2);
//        System.out.println("a is " + a1 + " and b is " + a2);

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }

    public static void swap(Integer a, Integer b) throws Exception {
        int temp = a.intValue();
        Field intField = Integer.class.getDeclaredField("value");
        intField.setAccessible(true);
        intField.set(a, b);
        intField.set(b, temp);
    }
}
