package com.ek.leetcode.bazinga.algorithm.easy;

/**
 * Copyright (C), 2019-2020
 * FileName: SolutionNo268
 * Author:   renyc
 * Date:     2020/9/5 7:20 下午
 * Description:
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 */
public class SolutionNo268 {
    public static void main(String[] args) {
        SolutionNo268 s = new SolutionNo268();
        System.out.println(s.missingNumber(new int[]{3, 0, 1, 5, 6, 7, 4}));
    }

    public int missingNumber(int[] nums) {
        int sum;
        int length = nums.length + 1;
        if (length % 2 == 0) {
            sum = (length - 1) * (length / 2);
        } else {
            sum = (length - 1) * (length / 2) + length / 2;
        }
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}