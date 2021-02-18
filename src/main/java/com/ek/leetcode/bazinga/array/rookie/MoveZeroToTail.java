package com.ek.leetcode.bazinga.array.rookie;

public class MoveZeroToTail {

    /***
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public void moveZeroToTail(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                if (zeroIndex < i) {
                    nums[i] = 0;
                }
                zeroIndex++;
            }
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
