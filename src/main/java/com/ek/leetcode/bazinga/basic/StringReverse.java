package com.ek.leetcode.bazinga.basic;

/**
 * Personal
 * Created by snakeek on 2018/4/6.
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "0987654321-=+";
        System.out.println("string : " + str + "\n after reverse : " + getReverseString(str));
    }

    private static String getReverseString(String oldStr) {
        if (oldStr == null) {
            return null;
        }
        if (oldStr.length() <= 1) {
            return oldStr;
        }

        StringBuilder sb = new StringBuilder();
        String lastChar = oldStr.substring(oldStr.length() - 1);
        sb.append(lastChar);
        String otherChar = getReverseString(oldStr.substring(0, oldStr.length() - 1));
        sb.append(otherChar);
        return sb.toString();
    }
}
