package com.ek.leetcode.bazinga.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), 2019-2021
 * FileName: CommonString
 * Author:   renyc
 * Date:     2021/2/25 10:57 上午
 * Description: 1
 */
public class CommonString {
    public static void main(String[] args) {
        int a = 1534236469;
        System.out.println(reverse(a));
        System.out.println(reverse(a * -1));

        System.out.println("===");
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int reverse(int x) {
        long num = 0;
        boolean flag = false;
        if (x == 0) {
            return x;
        }
        if (x < 0) {
            x = x * -1;
            flag = true;
        }
        while (x > 0) {
            num = (x%10) + num * 10;
            x = x / 10;
        }
        if (flag) {
            num = num * -1;
        }
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)num;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int right = 0;
        int max = 0;
        Queue<Character> queue = new LinkedList<>();
        while (right < chars.length) {
            if (!queue.contains(chars[right])) {
                queue.add(chars[right]);
            } else {
                queue.add(chars[right]);
                char c = queue.poll();
                while (c != chars[right]) {
                    c = queue.poll();
                }
            }
            if (max < queue.size()) {
                max = queue.size();
            }
            right++;
        }
        return max;
    }
}