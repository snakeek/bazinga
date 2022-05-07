package com.ek.leetcode.bazinga.algorithm.medium;

/**
 * Copyright (C), 2019-2022
 * FileName: SolutionNo167
 * Author:   renyc
 * Date:     2022/5/7 下午3:59
 * Description:
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class SolutionNo167 {

    public static void main(String[] args) {
        SolutionNo167 test = new SolutionNo167();
        int[] nums = new int[]{-1, 0};
        int[] res  = test.twoSum(nums, -1);
        for (int n : res) {
            System.out.println(n);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int tmp;
        while (low < high) {
            tmp = numbers[low] + numbers[high];
            if (tmp == target) {
                return new int[]{low + 1, high + 1};
            }
            if (tmp < target) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }
}