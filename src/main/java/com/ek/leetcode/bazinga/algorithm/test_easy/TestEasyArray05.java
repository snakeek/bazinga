package com.ek.leetcode.bazinga.algorithm.test_easy;

import java.util.Arrays;

/**
 * Copyright (C), 2019-2020
 * FileName: TestEasyArray05
 * Author:   renyc
 * Date:     2020/8/28 2:43 下午
 * Description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗?
 */
public class TestEasyArray05 {
    public static void main(String[] args) {
        TestEasyArray05 t = new TestEasyArray05();
        System.out.println(t.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        int tmp = 0;
        for (int num : nums) {
            tmp = tmp ^ num;
        }
        return tmp;
    }
}