package com.ek.leetcode.bazinga.codewar.kata5;

/**
 * Copyright (C), 2019-2020
 * FileName: LongestCommonSubsequence
 * Author:   renyc
 * Date:     2020/11/10 4:38 下午
 * Description:
 * Subsequence
 * A subsequence is different from a substring. The terms of a subsequence need not be consecutive terms of the original sequence.
 * <p>
 * Example subsequence
 * Subsequences of "abc" = "a", "b", "c", "ab", "ac", "bc" and "abc".
 * <p>
 * LCS examples
 * Solution.lcs("abcdef", "abc") => returns "abc"
 * Solution.lcs("abcdef", "acf") => returns "acf"
 * Solution.lcs("132535365", "123456789") => returns "12356"
 * Notes
 * Both arguments will be strings
 * Return value must be a string
 * Return an empty string if there exists no common subsequence
 * Both arguments will have one or more characters (in JavaScript)
 * All tests will only have a single longest common subsequence. Don't worry about cases such as LCS( "1234", "3412" ), which would have two possible longest common subsequences: "12" and "34".
 * Note that the Haskell variant will use randomized testing, but any longest common subsequence will be valid.
 * <p>
 * Note that the OCaml variant is using generic lists instead of strings, and will also have randomized tests (any longest common subsequence will be valid).
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        sort(new int[]{1, 5, 2, 7, 9, 3});
    }

    public static String lcs(String x, String y) {
        return "";
    }

    private static void sort(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
        for (int index = 0; index < arr.length; index++) {
            for (int j = 0; j < arr.length - index; j++) {
                int currNum = arr[index];
                if (arr[j] < currNum) {
                    arr[index] = arr[j];
                    arr[index + 1] = currNum;
                }
            }
        }

        System.out.println("========");
        for (int a : arr) {
            System.out.println(a);
        }
    }
}