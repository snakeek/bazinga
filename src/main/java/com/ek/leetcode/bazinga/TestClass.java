package com.ek.leetcode.bazinga;

import java.util.Arrays;

/**
 * Copyright (C), 2019-2021
 * FileName: TestClass
 * Author:   renyc
 * Date:     2021/4/2 10:59 上午
 * Description: 1
 */
public class TestClass {
    public static void main(String[] args) {
        int[] arr = new int[]{9,9,9,9,8,8,8,1,1};
        sortArr(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int sortArr(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int m = 0;
        int n = 1;
        int length = 1;
        int max = 2;
        while (n < nums.length) {
            if (nums[m] == nums[n]) {
                max--;
                if (max > 0) {
                    m++;
                }
            } else if ((m+1) == n) {
                max--;
                if (max > 0) {
                    m++;
                }
            } else {
                m++;
                nums[m] = nums[n];
                length++;
                max = 2;
            }
            n++;
        }
        return length;
    }
}