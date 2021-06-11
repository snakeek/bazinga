package com.ek.leetcode.bazinga.algorithm.sort;

/**
 * Created by snakeek on 2017/7/15.
 */
public class QuickSort {

    public static void quickSort(int[] numbers) {
        long start = System.nanoTime();
        if (numbers.length > 0) {
            quickSort(numbers, 0, numbers.length - 1);
        }
        long end = System.nanoTime();
        System.out.println("\nquick sort cost " + (end - start) + " ns.");
    }

    /**
     * 递归形式的分治排序
     *
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    private static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high);
            quickSort(numbers, low, middle - 1);
            quickSort(numbers, middle + 1, high);
        }
    }

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    private static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low];  //low for key value
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = temp;
        return low;
    }
}
