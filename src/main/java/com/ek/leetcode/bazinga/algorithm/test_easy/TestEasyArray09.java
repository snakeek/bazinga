package com.ek.leetcode.bazinga.algorithm.test_easy;

import java.util.*;

/**
 * Copyright (C), 2019-2020
 * FileName: TestEasyArray09
 * Author:   renyc
 * Date:     2020/8/31 5:58 下午
 * Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TestEasyArray09 {
    public static void main(String[] args) {
        TestEasyArray09 t = new TestEasyArray09();
        int[] arr = t.twoSum(new int[]{3, 2, 4, 15}, 6);
        for (int tmp : arr) {
            System.out.println(tmp);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((target - nums[i]))) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}