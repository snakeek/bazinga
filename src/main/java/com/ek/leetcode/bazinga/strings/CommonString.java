package com.ek.leetcode.bazinga.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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

        System.out.println("====");
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

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

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Map<Integer, Character> map = new HashMap<>();
        int index = 0;
        while (index < strs[0].length()) {
            map.put(index, strs[0].charAt(index));
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[0].charAt(index) != strs[i].charAt(index)) {
                    map.remove(index);
                    index = strs[0].length();
                    break;
                }
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * @param s
     * @return
     */
    public final String longestPalindrome(String s) {


        return null;
    }
}