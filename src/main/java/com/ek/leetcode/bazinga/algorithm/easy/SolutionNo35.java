package com.ek.leetcode.bazinga.algorithm.easy;

import com.ek.leetcode.bazinga.Solution;

/**
 * Copyright (C), 2019-2022
 * FileName: SolutionNo35
 * Author:   renyc
 * Date:     2022/5/5 下午4:49
 * Description:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SolutionNo35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        SolutionNo35 test = new SolutionNo35();
        System.out.println(test.searchInsert(nums, 5));
        System.out.println(test.searchInsert(nums, 2));
        System.out.println(test.searchInsert(nums, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0) {
            return 0;
        } else if (low == nums.length) {
            return nums.length;
        } else {
            return low;
        }
    }
}