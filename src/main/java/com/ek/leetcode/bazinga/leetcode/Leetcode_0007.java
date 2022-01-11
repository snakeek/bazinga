package com.ek.leetcode.bazinga.leetcode;

/**
 * Copyright (C), 2019-2021
 * FileName: Leetcode_0007
 * Author:   renyc
 * Date:     2021/12/2 上午10:18
 * Description:
 */
public class Leetcode_0007 {
    public static void main(String[] args) {
        Leetcode_0007 leetcode = new Leetcode_0007();
        System.out.println(leetcode.reverse(123));
        System.out.println(leetcode.reverse(1));
        System.out.println(leetcode.reverse(11));
        System.out.println(leetcode.reverse(0));
        System.out.println(leetcode.reverse(-123));
        //
        System.out.println(leetcode.reverse(1534236469));
    }

    public int reverse(int x) {
        int num = 0;
        while (x / 10 != 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        num = num * 10 + x % 10;
        return num;
    }
}