package com.ek.leetcode.bazinga.strings;

/**
 * Copyright (C), 2019-2021
 * FileName: CommonString
 * Author:   renyc
 * Date:     2021/2/25 10:57 上午
 * Description: 1
 */
public class CommonString {
    public static void main(String[] args) {
        int a = 1534236469;
        System.out.println(reverse(a));
        System.out.println(reverse(a * -1));
    }

    public static int reverse(int x) {
        long num = 0;
        boolean flag = false;
        if (x == 0) {
            return x;
        }
        if (x < 0) {
            x = x * -1;
            flag = true;
        }
        while (x > 0) {
            num = (x%10) + num * 10;
            x = x / 10;
        }
        if (flag) {
            num = num * -1;
        }
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)num;
    }
}