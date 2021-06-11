package com.ek.leetcode.bazinga.algorithm.easy;

import java.util.*;

/**
 * Copyright (C), 2019-2020
 * FileName: SolutionNo349
 * Author:   renyc
 * Date:     2020/9/5 7:36 下午
 * Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class SolutionNo349 {
    public static void main(String[] args) {
        SolutionNo349 s = new SolutionNo349();
        int[] arr = s.intersection(new int[]{4, 5, 9}, new int[]{9, 4, 4, 9});
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        int loop = Math.max(nums1.length, nums2.length);

        for (int i = 0; i < loop; i++) {
            if (i < nums1.length) {
                if (map.containsKey(nums1[i]) && (map.get(nums1[i]) == 2) && !result.contains(nums1[i])) {
                    result.add(nums1[i]);
                } else {
                    map.put(nums1[i], 1);
                }
            }
            if (i < nums2.length) {
                if (map.containsKey(nums2[i]) && (map.get(nums2[i]) == 1) && !result.contains(nums2[i])) {
                    result.add(nums2[i]);
                } else {
                    map.put(nums2[i], 2);
                }
            }
        }
        int[] arr = new int[result.size()];
        int i = 0;
        Iterator ite = result.iterator();
        while (ite.hasNext()) {
            arr[i] = (int) ite.next();
            i++;
        }
        return arr;
    }
}