package com.ek.leetcode.bazinga.codewar.kata6;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2020
 * FileName: Deakfish
 * Author:   renyc
 * Date:     2020/11/6 2:38 下午
 * Description:
 * Write a simple parser that will parse and run Deadfish.
 *
 * Deadfish has 4 commands, each 1 character long:
 *
 * i increments the value (initially 0)
 * d decrements the value
 * s squares the value
 * o outputs the value into the return array
 * Invalid characters should be ignored.
 *
 * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
 */
public class DeadFish {
    public static void main(String[] args) {
        int[] arr = DeadFish.parse("iiisdoso");
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static int[] parse(String data) {
        int value = 0;
        List<Integer> list = new ArrayList<>();
        for (char c : data.toCharArray()) {
            switch (c) {
                case 'i':
                    value++;
                    break;
                case 'd':
                    value--;
                    break;
                case 's':
                    value = value * value;
                    break;
                case 'o':
                    list.add(value);
                    break;
                default:
                    break;
            }
        }
        int[] returnArr = new int[list.size()];
        for (int i = 0; i < returnArr.length; i++) {
            returnArr[i] = list.get(i);
        }
        return returnArr;
    }
}