package com.ek.leetcode.bazinga.leetcode;

/**
 * Copyright (C), 2019-2022
 * FileName: Leetcode_0035
 * Author:   renyc
 * Date:     2022/1/18 下午2:52
 * Description:
 */
public class Leetcode_0035 {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        low = high;
        System.out.println("low and high : " + low + "  " + high);
        return low;
    }

    public static void main(String[] args) {
        Leetcode_0035 test = new Leetcode_0035();
        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(test.searchInsert(new int[]{1}, 0));
    }
}