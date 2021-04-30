package com.ek.leetcode.bazinga.algorithm.easy;

/**
 * Copyright (C), 2019-2020
 * FileName: SolutionNo88
 * Author:   renyc
 * Date:     2020/9/5 8:09 下午
 * Description:
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class SolutionNo88 {
    public static void main(String[] args) {
        SolutionNo88 s = new SolutionNo88();
        int[] nums = new int[]{1, 2, 3, 0, 0, 0};
        s.merge(nums, 3, new int[]{2, 5, 6}, 3);
        for (int a : nums) {
            System.out.println(a);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        for (int i = 0; i < nums1.length; i++) {
            if (m > 0 && n > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[nums1.length - 1 - i] = nums1[m - 1];
                nums1[m - 1] = 0;
                m--;
            } else if (n > 0) {
                nums1[nums1.length - 1 - i] = nums2[n - 1];
                nums2[n - 1] = 0;
                n--;
            }
        }
    }
}