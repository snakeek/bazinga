package com.ek.leetcode.bazinga.array.rookie;

public class RemoveGivenValue {

    /***
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */

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
