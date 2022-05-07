package com.ek.leetcode.bazinga.algorithm.medium;

/**
 * Copyright (C), 2019-2022
 * FileName: SolutionNo189
 * Author:   renyc
 * Date:     2022/5/6 下午6:04
 * Description:
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class SolutionNo189 {

    public static void main(String[] args) {
        SolutionNo189 test = new SolutionNo189();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        test.rotate(arr, 3);
        System.out.println("========");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }
}