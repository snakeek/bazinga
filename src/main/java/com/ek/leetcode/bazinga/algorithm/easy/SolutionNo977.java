package com.ek.leetcode.bazinga.algorithm.easy;

/**
 * Copyright (C), 2019-2022
 * FileName: SolutionNo977
 * Author:   renyc
 * Date:     2022/5/6 上午1:12
 * Description:
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class SolutionNo977 {

    public static void main(String[] args) {
        int[] nums = {};
        SolutionNo977 test = new SolutionNo977();
        int[] res = test.sortedSquares(nums);
        for (int n : res) {
            System.out.println(n);
        }
    }

    public int[] sortedSquares(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        int leftNum;
        int rightNum;
        int[] res = new int[nums.length];
        for (int i = res.length - 1; i >= 0; i--) {
            leftNum = nums[left] * nums[left];
            rightNum = nums[right] * nums[right];
            if (leftNum >= rightNum) {
                res[i] = leftNum;
                left++;
            } else {
                res[i] = rightNum;
                right--;
            }
        }
        return res;
    }
}