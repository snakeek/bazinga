package com.ek.leetcode.bazinga.leetcode;

/**
 * Personal
 * Created by snakeek on 2018/5/21.
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3, 2, 3}, 6);
        System.out.println(result[0] + " and " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > target || nums[j] > target) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
