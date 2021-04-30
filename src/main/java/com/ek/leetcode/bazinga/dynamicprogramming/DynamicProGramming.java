package com.ek.leetcode.bazinga.dynamicprogramming;

/**
 * Copyright (C), 2019-2021
 * FileName: PackageSolution
 * Author:   renyc
 * Date:     2021/2/25 4:03 下午
 * Description: 1
 */
public class DynamicProGramming {
    public static void main(String[] args) {

        System.out.println(climbStairs(5));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println("==rob===");
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

        System.out.println("===max sub array===");
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("===max same sub string===");
        System.out.println(getMaxSameSubString("abbca", "bbca"));
    }

    /*
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public static int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (dp[0] > prices[i]) {
                dp[0] = prices[i];
            }
            if ((prices[i] - dp[0]) > dp[1]) {
                dp[1] = prices[i] - dp[0];
            }
        }
        return dp[1];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public static int rob(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        if (nums.length >= 1) {
            dp[0] = nums[0];
            max = dp[0];
        }
        if (nums.length >= 2) {
            dp[1] = Math.max(dp[0], nums[1]);
            max = dp[1];
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0) {
                nums[i] = pre + nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            pre = nums[i];
        }
        return max;
    }

    /**
     * 获取两个字符串的最长公共子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String getMaxSameSubString(String str1, String str2) {
        if (str1 == null || str1.length() == 0) {
            return "";
        }
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        int[][] dp = new int[str1.length()][str2.length()];
        int max = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) != str2.charAt(j)) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return "" + max;
    }
}