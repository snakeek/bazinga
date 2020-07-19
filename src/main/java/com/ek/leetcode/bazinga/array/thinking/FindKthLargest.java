package com.ek.leetcode.bazinga.array.thinking;

public class FindKthLargest {

    /***
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * @param nums
     * @param k
     * @return
     */
    //TODO 改用快排
    public int findKthLargest(int[] nums, int k) {
        int head = 0;
        int temp;
        while (head < k) {
            for (int i = head + 1; i < nums.length; i++) {
                if (nums[i] > nums[head]) {
                    temp = nums[head];
                    nums[head] = nums[i];
                    nums[i] = temp;
                }
            }
            head++;
        }
        return nums[head-1];
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] first = new int[]{3,2,1,5,6,4};
        //5
        System.out.println(findKthLargest.findKthLargest(first, 2));
        int[] second = new int[]{3,2,3,1,2,4,5,5,6};
        //4
        System.out.println(findKthLargest.findKthLargest(second, 4));
    }
}
