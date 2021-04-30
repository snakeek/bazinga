package com.ek.leetcode.bazinga.codewar.kata5;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2020
 * FileName: Greed
 * Author:   renyc
 * Date:     2020/11/10 4:11 下午
 * Description:
 * Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
 * <p>
 * Three 1's => 1000 points
 * Three 6's =>  600 points
 * Three 5's =>  500 points
 * Three 4's =>  400 points
 * Three 3's =>  300 points
 * Three 2's =>  200 points
 * One   1   =>  100 points
 * One   5   =>   50 point
 * A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
 * <p>
 * Example scoring
 * <p>
 * Throw       Score
 * ---------   ------------------
 * 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 * 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 * 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 * In some languages, it is possible to mutate the input to the function. This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.
 */
public class Greed {

    public static void main(String[] args) {
        System.out.println("" + greedy(new int[]{5, 1, 3, 4, 1}));
        System.out.println("" + greedy(new int[]{1, 1, 1, 3, 1}));
        System.out.println("" + greedy(new int[]{2, 4, 4, 5, 4}));
    }

    public static int greedy(int[] dice) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : dice) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int point = 0;
        Integer num;
        int count;
        for (Integer integer : map.keySet()) {
            num = integer;
            count = map.get(num);
            point += getPoints(num, count);
        }

        return point;
    }

    private static int getPoints(int value, int count) {
        switch (value) {
            case 1:
                if (count >= 3) {
                    return 1000 + (count - 3) * 100;
                } else {
                    return count * 100;
                }
            case 2:
                if (count >= 3) {
                    return 200;
                } else {
                    return 0;
                }
            case 3:
                if (count >= 3) {
                    return 300;
                } else {
                    return 0;
                }
            case 4:
                if (count >= 3) {
                    return 400;
                } else {
                    return 0;
                }
            case 5:
                if (count >= 3) {
                    return 500 + (count - 3) * 50;
                } else {
                    return 50 * count;
                }
            case 6:
                if (count >= 3) {
                    return 600;
                } else {
                    return 0;
                }
            default:
                return 0;
        }
    }
}