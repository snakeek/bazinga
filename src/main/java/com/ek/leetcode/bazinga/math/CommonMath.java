package com.ek.leetcode.bazinga.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2021
 * FileName: CommonMath
 * Author:   renyc
 * Date:     2021/2/26 1:44 下午
 * Description: 1
 */
public class CommonMath {
    public static void main(String[] args) {
        System.out.println(hammingDistance(7, 5));

        System.out.println("generate");
        List<List<Integer>> lists = generate(5);
        for (List<Integer> list : lists) {
            System.out.println("==");
            list.stream().forEach(System.out::print);
        }

        missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    public static int hammingDistance(int x, int y) {
        int distance = 0;
        int tmp = x ^ y;
        while (tmp != 0) {
            distance++;
            tmp = tmp & (tmp - 1);
        }
        return distance;
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        if (numRows >= 1) {
            list.add(1);
            lists.add(list);
        }
        if (numRows >= 2) {
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            lists.add(list);
        }
        for (int i = 3; i <= numRows; i++) {
            list = lists.get(i - 2);
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < list.size() + 1; j++) {
                if (j == 0 || j == list.size()) {
                    newList.add(1);
                } else {
                    newList.add(list.get(j - 1) + list.get(j));
                }
            }
            lists.add(newList);
        }

        return lists;
    }

    public static int missingNumber(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int reduce = 0;
        for (int i = 0; i < nums.length; i++) {
            reduce = reduce ^ nums[i] ^ i;
        }
        return reduce ^ nums.length;
    }
}