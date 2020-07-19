package com.ek.leetcode.bazinga.array.thinking;

public class SortColors {

    /***
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * @param nums
     */
    public void sortColors(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        int jump = 1;
        int temp;
        while (head < tail) {
            if (nums[head] > 1) {
                temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
                tail--;
            } else if (nums[head] < 1) {
                head++;
                jump = 1;
            } else if ((head+jump) <= tail) {
                temp = nums[head];
                nums[head] = nums[head + jump];
                nums[head + jump] = temp;
                jump++;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(arr);
        for (Integer num : arr) {
            System.out.print(num);
        }
    }
}
