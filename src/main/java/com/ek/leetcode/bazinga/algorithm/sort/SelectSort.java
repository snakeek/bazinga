package com.ek.leetcode.bazinga.algorithm.sort;

/**
 * Created by snakeek on 2017/7/15.
 */
public class SelectSort {
    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    public static void selectSort(int[] numbers) {
        long start = System.nanoTime();
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            int k = i;
            for (int j = i + 1; j < size; j++) {
                if (numbers[k] > numbers[j]) {
                    k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
        long end = System.nanoTime();
        System.out.println("\nselect sort cost " + (end - start) + " ns.");
    }
}
