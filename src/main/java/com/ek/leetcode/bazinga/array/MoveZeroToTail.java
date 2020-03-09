package com.ek.leetcode.bazinga.array;

import java.util.Arrays;

public class MoveZeroToTail {

    public void moveZeroToTail(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }

        for (; zeroIndex < nums.length; zeroIndex++) {
            nums[zeroIndex] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroToTail test = new MoveZeroToTail();
        int[] arr = new int[]{0,1,0,3,12};
        test.moveZeroToTail(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
