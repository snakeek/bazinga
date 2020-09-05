package com.ek.leetcode.bazinga.algorithm.easy;

/**
 * Copyright (C), 2019-2020
 * FileName: SolutionNo191
 * Author:   renyc
 * Date:     2020/9/4 7:38 下午
 * Description:
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class SolutionNo191 {

    public static void main(String[] args) {
        SolutionNo191 s = new SolutionNo191();
    }

    public int hammingWeight(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if ((n>>i & 1) == 1) {
                num++;
            }
        }
        return num;
    }

    public int best(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n-1);
        }
        return sum;
    }
}