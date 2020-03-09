package com.ek.leetcode.bazinga.array;

public class RemoveGivenValue {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int valueIndex = 0;
        int returnValue;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[valueIndex] = nums[i];
                valueIndex++;
            }
        }
        returnValue = valueIndex;
        for (; valueIndex < nums.length; valueIndex++) {
            nums[valueIndex] = val;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        RemoveGivenValue test = new RemoveGivenValue();
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(test.removeElement(arr, 2));
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
