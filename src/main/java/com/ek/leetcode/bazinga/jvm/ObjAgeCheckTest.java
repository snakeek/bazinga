package com.ek.leetcode.bazinga.jvm;

/**
 * Created by snakeek on 2018/4/29.
 */
public class ObjAgeCheckTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
//        byte[] allocation1, allocation2, allocation3, allocation4;
//        allocation1 = new byte[_1MB / 4];
//        allocation2 = new byte[4 * _1MB];
//        allocation3 = new byte[4 * _1MB];
//        allocation3 = null;
//        allocation4 = new byte[4 * _1MB];
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
