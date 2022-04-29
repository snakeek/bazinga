package com.ek.leetcode.bazinga.leetcode;

/**
 * Copyright (C), 2019-2021
 * FileName: Leetcode_0009
 * Author:   renyc
 * Date:     2021/12/2 下午8:36
 * Description:
 */
public class Leetcode_0009 {

    public static void main(String[] args) {
        Leetcode_0009 leetcode = new Leetcode_0009();
        System.out.println(leetcode.isPalindrome(121));
        System.out.println(leetcode.isPalindrome(123));
        System.out.println(leetcode.isPalindrome(-12));
        System.out.println(leetcode.isPalindrome(0));
        System.out.println(leetcode.isPalindrome(11));
    }

    public boolean isPalindrome(int x) {
        if (x < 10 && x >= 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int a = 0;
        int b = s.length() - 1;



        return false;
    }
}