package com.ek.leetcode.bazinga.algorithm.easy;

import java.util.Arrays;

public class SolutionNo1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        if (nums.length < 2) {
            return nums;
        }

        int indexA;
        int indexB;
        for (int i = 0; i < nums.length; i++) {
            indexA = i;
            for (int j = i + 1; j < nums.length; j++) {
                indexB = j;
                if (nums[indexA] + nums[indexB] == target) {
                    return new int[]{indexA, indexB};
                }
            }
        }
        return null;
    }

    public int[] twoSumBest(int[] nums, int target) {
        //空间换时间，缓存遍历过的数据

        return null;
    }

    public static void main(String[] args) {
        SolutionNo1 solution = new SolutionNo1();
        int[] arr = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
