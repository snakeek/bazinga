package com.ek.leetcode.bazinga.leetcode;

/**
 * Copyright (C), 2019-2022
 * FileName: Leetcode_0704
 * Author:   renyc
 * Date:     2022/1/13 下午5:57
 * Description:
 */
public class Leetcode_0704 {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        int mid;
        while (low <= high) {
            mid = (low+high)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Leetcode_0704 test = new Leetcode_0704();
//        System.out.println(test.search(new int[]{-1,0,3,5,9,12}, 9));
//        System.out.println(test.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(test.search(new int[]{-1,0,3,5,9,12}, 13));
    }
}