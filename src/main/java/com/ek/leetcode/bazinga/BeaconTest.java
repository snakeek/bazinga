package com.ek.leetcode.bazinga;

import java.util.*;

/**
 * Copyright (C), 2019-2022
 * FileName: BeaconTest
 * Author:   renyc
 * Date:     2022/1/27 下午4:44
 * Description:
 */
public class BeaconTest {

    public static void main(String[] args) {
        //first
//        int[] a = new int[]{1,5,8,9};
//        int[] b = new int[]{2,4,6,7};
        BeaconTest test = new BeaconTest();
//        int[] c = test.combine(a, b);
//        for (int tmp : c) {
//            System.out.println(tmp);
//        }

        //second
//        List<List<Integer>> list = test.generate(5);
//        for (List<Integer> tmpList : list) {
//            for (Integer i : tmpList) {
//                System.out.printf(i + "  ");
//            }
//            System.out.println("==");
//        }

        //third
//        List<List<Integer>> list = test.combine(4,2);
//        for (List<Integer> tmpList : list) {
//            for (Integer i : tmpList) {
//                System.out.printf(i + "  ");
//            }
//            System.out.println("==");
//        }

        //fourth
//        int[] arr = test.twoSum(new int[]{2,7,11,15}, 9);
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);

        //fifth
        System.out.println(test.reverse(-123));
        System.out.println(test.reverse(6576863));
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 输入：x = 123
     * 输出：321
     */
    public  int reverse(int x){
        if (x == 0) {
            return x;
        }
        int reverse = 0;
        int flag;
        if (x > 0) {
            flag = 1;
        } else {
            flag = -1;
            x = x * -1;
        }
        while (x > 0) {
            //Integer.Max?Min
            reverse = x % 10  + reverse * 10;
            x = x / 10;
        }
        return reverse * flag;
    }

    /**
     * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     *
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */
    public int[] twoSum(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{index + 1, i + 1};
            }
        }
        return new int[2];
    }

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     *
     * 你需要按照升序序列 返回答案。
     *
     * 输入：n = 4, k = 2
     * 输出：
     * [[1,2],
     * [1,3],
     * [1,4],[2,3],
     * [2,4],
     * [3,4],]
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return new ArrayList<>();
        }
        List<List<Integer>> returnList = new ArrayList<>();
        if (n == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            returnList.add(list);
            return returnList;
        }

        int i = 1;
        while (i <= n) {
            for (int j = i+1; j <= n; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                int num = j;
                while (list.size() < k) {
                    list.add(num);
                    num++;
                    if (num > n) {
                        break;
                    }
                }
                if (list.size() == k) {
                    returnList.add(list);
                }
            }
            i++;
        }
        return returnList;
    }

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     *
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * image.png
     *
     * 例如：
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i < 2) {
                    list.add(1);
                    continue;
                }
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(returnList.get(i-1).get(j - 1) + returnList.get(i-1).get(j));
                }
            }
            returnList.add(list);
        }
        return returnList;
    }

    /**
     * 将两个有序升序数组，合并成为一个有序升序数组：
     *
     * 比如：
     *
     * 数组A : 1,5,8,9
     * 数组B : 2,4,6,7
     *
     * 合并的结果应该为 ： 1,2,4,5,6,7,8,9
     */
    public  int[] combine(int[] a,int[] b) {
        if (a == null && b == null) {
            return new int[]{};
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int[] arr = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        while (true) {
            if (indexA == a.length && indexB == b.length) {
                return arr;
            } else if (indexA == a.length) {
                arr[indexA + indexB] = b[indexB];
                indexB++;
                continue;
            } else if (indexB == b.length) {
                arr[indexA + indexB] = a[indexA];
                indexA++;
                continue;
            }
            if (a[indexA] <= b[indexB]) {
                arr[indexA + indexB] = a[indexA];
                indexA++;
            } else {
                arr[indexA + indexB] = b[indexB];
                indexB++;
            }
        }
    }
}