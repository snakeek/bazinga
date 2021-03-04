package com.ek.leetcode.bazinga.dynamicprogramming;

/**
 * Copyright (C), 2019-2021
 * FileName: HardDP
 * Author:   renyc
 * Date:     2021/3/4 3:40 下午
 * Description: 1
 */
public class HardDP {
    public static void main(String[] args) {

    }

    /**
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        if (envelopes.length == 1) {
            return 1;
        }
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][0] < envelopes[i-1][0] && envelopes[i][1] < envelopes[i-1][1]) {
                dp[i] = dp[i-1] + 1;
            }
        }

        return -1;
    }
}