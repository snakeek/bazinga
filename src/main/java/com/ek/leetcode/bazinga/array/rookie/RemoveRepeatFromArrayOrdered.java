package com.ek.leetcode.bazinga.array.rookie;

public class RemoveRepeatFromArrayOrdered {

    /***
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 1;
        int value = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (value != nums[i]) {
                nums[index] = nums[i];
                index++;
                value = nums[i];
            }
        }

        return index;
    }

    /***
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public int removeDuplicatesTwice(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int index = 1;
        int value = nums[0];
        int counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (value != nums[i]) {
                value = nums[i];
                nums[index] = nums[i];
                index++;
                counter = 1;
            } else {
                if (counter < 2) {
                    nums[index] = nums[i];
                    index++;
                }
                counter++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        RemoveRepeatFromArrayOrdered test = new RemoveRepeatFromArrayOrdered();
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(test.removeDuplicates(arr));
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println("==========================================");
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(test.removeDuplicatesTwice(nums));
        for (int num : nums) {
            System.out.print(num);
        }

        int[] t = new int[]{1,2};
        int n = 0;
        System.out.println("=============================");
        System.out.println(t[n++]);
    }
}
