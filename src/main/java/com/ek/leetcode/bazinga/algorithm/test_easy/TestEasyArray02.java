package com.ek.leetcode.bazinga.algorithm.test_easy;

public class TestEasyArray02 {
    public static void main(String[] args) {
        TestEasyArray02 t = new TestEasyArray02();
        System.out.println(t.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int index = 0;
        int earn = 0;
        int tmp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[index] > prices[i]) {
                if (tmp > 0) {
                    earn += tmp;
                    tmp = 0;
                }
                index = i;
                continue;
            }
            if (tmp < (prices[i] - prices[index])) {
                tmp = prices[i] - prices[index];
            } else {
                earn += tmp;
                tmp = 0;
                index = i;
            }
        }
        if (tmp > 0) {
            earn += tmp;
        }
        return earn;
    }
}
