package com.ek.leetcode.bazinga.algorithm.test_easy;

import java.util.Arrays;

/**
 * Copyright (C), 2019-2020
 * FileName: TestEasyArray07
 * Author:   renyc
 * Date:     2020/8/28 7:23 下午
 * Description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class TestEasyArray07 {

    public static void main(String[] args) {
        TestEasyArray07 t = new TestEasyArray07();
        int[] a = t.plusOne(new int[]{8, 9, 9, 9});
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int add = 0;
        int tmp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp += digits[i] + add;
            System.out.println(tmp);
            if (tmp <= 9) {
                digits[i] = tmp;
                return digits;
            }
            digits[i] = tmp % 10;
            tmp = digits[i];
            add = 1;
        }
        if (add > 0) {
            int[] newArr = new int[len + 1];
            newArr[0] = add;
            int i = 1;
            for (int num : digits) {
                newArr[i] = num;
                i++;
            }
            return newArr;
        }
        return null;
    }
}