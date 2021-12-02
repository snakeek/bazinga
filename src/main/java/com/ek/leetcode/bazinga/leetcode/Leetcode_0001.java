package com.ek.leetcode.bazinga.leetcode;

/**
 * Copyright (C), 2019-2021
 * FileName: Leetcode_0001
 * Author:   renyc
 * Date:     2021/11/30 下午5:46
 * Description:
 */
public class Leetcode_0001 {

    public static void main(String[] args) {
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        Leetcode_0001 test = new Leetcode_0001();
        long start = System.nanoTime();
        int[] arr = test.twoSum(new int[]{-10,-1,-18,-19}, -19);
        long end = System.nanoTime();
        for (int num : arr) {
            System.out.println(num);
        }
        System.out.println(end-start + "ns");
    }

    public int[] twoSum(int[] nums, int target) {
        Integer num = null;
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num == null) {
                first = i;
                num = nums[i];
                continue;
            }
            if ((target - num) == nums[i]) {
                return new int[]{first, i};
            }
            if (i + 1 == nums.length) {
                num = null;
                i = first;
            }
        }
        return new int[]{-1,-1};
     }
     //Map 最快，优化！！
}