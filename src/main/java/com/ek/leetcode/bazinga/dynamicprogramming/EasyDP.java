package com.ek.leetcode.bazinga.dynamicprogramming;

/**
 * Copyright (C), 2019-2021
 * FileName: EasyDP
 * Author:   renyc
 * Date:     2021/3/4 2:56 下午
 * Description: 1
 */
public class EasyDP {
    public static void main(String[] args) {
        System.out.println(divisorGame(2));

        System.out.println(waysToStep(5));
    }

    public static boolean divisorGame(int N) {
        //定义 dp[i]为true表示先手赢，false表示先手输
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j) == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }


    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     *
     * @param n
     * @return
     */
    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
        }

        return dp[n];
    }
}