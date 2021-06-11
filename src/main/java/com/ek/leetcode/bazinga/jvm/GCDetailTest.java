package com.ek.leetcode.bazinga.jvm;

/**
 * Created by snakeek on 2018/4/21.
 */
public class GCDetailTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.gc();
        System.out.println();
        obj = new Object();
        obj = new Object();
        System.gc();
        System.out.println();
    }
}
