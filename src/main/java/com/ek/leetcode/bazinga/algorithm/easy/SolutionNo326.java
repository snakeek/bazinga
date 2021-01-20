package com.ek.leetcode.bazinga.algorithm.easy;

/**
 * Copyright (C), 2019-2020
 * FileName: Solution326
 * Author:   renyc
 * Date:     2020/9/5 6:58 下午
 * Description:
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class SolutionNo326 {
    public static void main(String[] args) {
        SolutionNo326 s = new SolutionNo326();
        System.out.println(s.isPowerOfThree(6));
    }

    public boolean isPowerOfThree(int n) {
        boolean flag = true;
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            if (n == 0) {
                return false;
            }
            n = n / 3;
        }
        return flag;
    }

    public boolean best(int n) {
        return (n > 0) && (1162261467 % n == 0);
    }
}