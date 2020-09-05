package com.ek.leetcode.bazinga.algorithm.test_easy;

public class TestEasyString01 {
    public static void main(String[] args) {
        TestEasyString01 t = new TestEasyString01();
        char[] arr = "helloj".toCharArray();
        t.reverseString(arr);
        System.out.println(new String(arr));
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return ;
        }
        int mid = s.length / 2;
        char tmp;
        for (int i = 0; i < mid; i++) {
            tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
    }
}
