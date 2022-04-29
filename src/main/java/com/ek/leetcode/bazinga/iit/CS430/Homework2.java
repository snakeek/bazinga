package com.ek.leetcode.bazinga.iit.CS430;

import java.util.Arrays;
import java.util.Random;

/**
 * Copyright (C), 2019-2022
 * FileName: Homework2
 * Author:   renyc
 * Date:     2022/3/27 下午2:15
 * Description:
 */
public class Homework2 {

    public static void main(String[] args) {
//        int[] arr = {7,2,5,7,2,0,5,3,6,0,3,3,5,9,0,6};
//        System.out.println("arrays : ");
//        Arrays.stream(arr).forEach(x -> System.out.print(" " + x));
//        System.out.println("");
//        Homework2.QuickSort(arr, 0,arr.length-1);
//        System.out.println("sorted array is : ");
//        Arrays.stream(arr).forEach(x -> System.out.print(" " + x));

        int length = 1000;
        int[] arr;
        long start;
        long end;
        for (int i = 0; i < 10; i++) {
            arr = getRandomArray(length);
            start = System.nanoTime();
            Homework2.QuickSort(arr, 0, length - 1);
            end = System.nanoTime();
            System.out.println("random arr length : " + length + "    cost : " + (end - start));
        }

//        for (int i = 0; i < 10; i++) {
//            arr = getSameArray(length);
//            start = System.nanoTime();
//            Homework2.QuickSort(arr, 0, length - 1);
//            end = System.nanoTime();
//            System.out.println("all same arr length : " + length + "    cost : " + (end - start));
//        }
//
//        for (int i = 0; i < 10; i++) {
//            arr = getOrderedArray(length, false);
//            start = System.nanoTime();
//            Homework2.QuickSort(arr, 0, length - 1);
//            end = System.nanoTime();
//            System.out.println("DESC ordered arr length : " + length + "    cost : " + (end - start));
//        }
//
//        for (int i = 0; i < 10; i++) {
//            arr = getOrderedArray(length, true);
//            start = System.nanoTime();
//            Homework2.QuickSort(arr, 0, length - 1);
//            end = System.nanoTime();
//            System.out.println("ASC ordered arr length : " + length + "    cost : " + (end - start));
//        }
    }

    private static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    private static int[] getOrderedArray(int length, boolean isAsc) {
        int[] arr = new int[length];
        if (isAsc) {
            for (int i = 0; i < length; i++) {
                arr[i] = i;
            }
        } else {
            for (int i = 0; i < length; i++) {
                arr[i] = length - i - 1;
            }
        }
        return arr;
    }

    private static int[] getSameArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = 6;
        }
        return arr;
    }

    private static void QuickSort(int[] array, int p, int r) {
        String pStr;
        String rStr;
        if (p < r) {
            int q = partition(array, p, r);
            //p:<p-value> r:<r-value> A: [<left-subarray>]-|<Pivot>|-[<right-subarray>]
            pStr = p + "";
            rStr = r + "";
            if (p < 10) {
                pStr = " " + pStr;
            }
            if (r < 10) {
                rStr = " " + rStr;
            }
//            System.out.print("p: " + pStr + "  r: " + rStr + "  A: [");
//            for (int i = 0; i < q; i++) {
//                System.out.print(" " + array[i]);
//            }
//            System.out.print(" ]-|" + array[q] + "|-[");
//            for (int i = q + 1; i < array.length; i++) {
//                System.out.print(" " + array[i]);
//            }
//            System.out.println(" ]");
            QuickSort(array, p, q - 1);
            QuickSort(array, q + 1, r);
        }
    }

    private static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        int tmp;
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        tmp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = tmp;
        return i + 1;
    }
}