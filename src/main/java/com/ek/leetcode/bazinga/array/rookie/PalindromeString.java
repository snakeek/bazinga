package com.ek.leetcode.bazinga.array.rookie;

/**
 * Copyright (C), 2019-2021
 * FileName: PalindromeString
 * Author:   renyc
 * Date:     2021/2/18 3:38 下午
 * Description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9tqjc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PalindromeString {

    public static void main(String[] args) {

        System.out.println(isPalindromeOther("0P"));
        System.out.println(isPalindromeOther("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeOther("race a car"));
        System.out.println(isPalindromeOther(""));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeOther(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (isLegal(chars[left]) && isLegal(chars[right]) && chars[left] == chars[right]) {
                left++;
                right--;
            } else if (!isLegal(chars[left])) {
                left++;
            } else if (!isLegal(chars[right])) {
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isLegal(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}