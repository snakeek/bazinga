package com.ek.leetcode.bazinga.algorithm;

import com.ek.leetcode.bazinga.algorithm.sort.*;

/**
 * Created by snakeek on 2017/7/15.
 */
public class SortTest {
    public static void main(String[] args) {
        int[] numbers = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        BubbleSort.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }

        System.out.println();
        numbers = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        QuickSort.quickSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }

        System.out.println();
        numbers = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        SelectSort.selectSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }

        System.out.println();
        numbers = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        InsertSort.insertSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }

        System.out.println();
        numbers = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        ShellSort.shellSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }

        System.out.println();
        numbers = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        MergeSort.mergeSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
    }
}
