package com.ek.leetcode.bazinga.algorithm.sort;

/**
 * Created by snakeek on 2017/7/15.
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    public static void sort(int[] numbers) {
        long start = System.nanoTime();
        sortUp(numbers);
        long end = System.nanoTime();
        System.out.println("\nbubble sort cost " + (end - start) + " ns.");
    }

    //由小到大沉底
    private static void sortDown(int[] numbers) {
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    //由大到小冒泡
    private static void sortUp(int[] numbers) {
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
