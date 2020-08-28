package com.ek.leetcode.bazinga.algorithm.test_easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class TestEasyArray04 {
    public static void main(String[] args) {
        TestEasyArray04 t = new TestEasyArray04();
        if (t.containsDuplicate(new int[]{1,2,3,4,5})) {
            System.out.println("something same!");
        } else {
            System.out.println("nothing same!");
        }
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> checkSet = new HashSet<>();
        for (int num : nums) {
            if (!checkSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
