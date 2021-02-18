package com.ek.leetcode.bazinga.array.rookie;

/**
 * Copyright (C), 2019-2021
 * FileName: FindMinSubArrayLen
 * Author:   renyc
 * Date:     2021/2/18 6:51 下午
 * Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9gogt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindMinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
        nums = new int[]{1,4,4};
        System.out.println(minSubArrayLen(1, nums));
        nums = new int[]{1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < nums.length) {
            sum += nums[right];
            count++;
            right++;
            while (sum >= target) {
                if (res == 0 || count < res) {
                    res = count;
                }
                count--;
                sum -= nums[left];
                left++;
            }
        }
        return res;
    }
}