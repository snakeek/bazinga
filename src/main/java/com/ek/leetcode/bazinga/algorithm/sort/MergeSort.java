package com.ek.leetcode.bazinga.algorithm.sort;

/**
 * Created by snakeek on 2017/7/16.
 */
public class MergeSort {

    public static int[] mergeSort(int[] numbers) {
        long start = System.nanoTime();
        int[] nums = mergeSort(numbers, 0, numbers.length - 1);
        long end = System.nanoTime();
        System.out.println("\nmerge sort cost " + (end - start) + " ns.");
        return nums;
    }

    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     *
     * @param numbers 待排序数组
     * @return 输出有序数组
     */
    private static int[] mergeSort(int[] numbers, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //left
            mergeSort(numbers, low, mid);
            //right
            mergeSort(numbers, mid + 1, high);
            //merge
            merge(numbers, low, mid, high);
        }
        return numbers;
    }

    /**
     * 将数组中low到high位置的数进行排序
     *
     * @param numbers 待排序数组
     * @param low     待排的开始位置
     * @param mid     待排中间位置
     * @param high    待排结束位置
     */
    private static void merge(int[] numbers, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        //把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (numbers[i] < numbers[j]) {
                temp[k++] = numbers[i++];
            } else {
                temp[k++] = numbers[j++];
            }
        }

        //把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = numbers[i++];
        }
        //把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = numbers[j++];
        }
        //把新数组中的数覆盖nums数组
        for (int m = 0; m < temp.length; m++) {
            numbers[m + low] = temp[m];
        }
    }
}
