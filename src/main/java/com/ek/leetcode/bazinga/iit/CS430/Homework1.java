package com.ek.leetcode.bazinga.iit.CS430;

import java.util.*;

/**
 * Copyright (C), 2019-2022
 * FileName: Homework1
 * Author:   renyc
 * Date:     2022/2/20 下午3:26
 * Description:
 */
public class Homework1 {

    public static void main(String[] args) {
        Homework1 homework = new Homework1();
        //prove test
        proveRandUniformDistribution();

        //data and cost
        List<Integer> lengthList = new ArrayList<>();
        List<Long> timeList = new ArrayList<>();
        //line data
        int length = 1000000;
        int step = 50000;
        int[] steps = new int[]{5,2};
        int count = 0;
        while (length <= 10000000) {
            int[] arr = generateNumberArr(length);
            long start = System.currentTimeMillis();
            homework.mergeSort(arr);
            long end = System.currentTimeMillis();
            System.out.print("length : " + length + "    -    cost : " + (end-start) + "ms\n");
            lengthList.add(length);
            timeList.add(end-start);
            length += step;
        }
        for (Integer n : lengthList) {
            System.out.print(n + ",");
        }
        System.out.println("");
        for (Long l : timeList) {
            System.out.print(l + ",");
        }
        //result check
        int[][] arr = new int[][]{{9,5,8,4,7,3,6,2},{0},{0,0,0},{1,1,3,3,5},{1,4,3,1,3,4},{1,1,3,3,9,1,2}};
        for (int[] tmpArr : arr) {
            homework.mergeSort(tmpArr);
            for (int num : tmpArr) {
                System.out.print(num + " -> ");
            }
            System.out.println("next...");
        }
    }

    public static void proveRandUniformDistribution() {
        System.out.println("Prove random uniform distributed. Avg count of each zone is 100000");
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] list = generateNumberArr(1000000);
        int tmpNum;
        for (int num : list) {
            tmpNum = num % 10;
            if (countMap.containsKey(tmpNum)) {
                countMap.put(tmpNum, countMap.get(tmpNum) + 1);
            } else {
                countMap.put(tmpNum, 1);
            }
        }
        for (Integer key : countMap.keySet()) {
            System.out.println(" key : " + key + "    value : " + countMap.get(key));
        }
    }

    public static int[] generateNumberArr(int arrLength) {
//        long seed = System.currentTimeMillis();
        Random random = new Random();
        int[] arr = new int[arrLength];
        int length = 0;
        while (length < arrLength) {
            arr[length] = random.nextInt(arrLength);
            length++;
        }
        return arr;
    }

    private void mergeSort(int[] numbers) {
        if (numbers == null || numbers.length == 1) {
            return;
        }
        sort(numbers, 0, numbers.length - 1);
    }

    private void sort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left)/2;
        sort(numbers, left, mid);
        sort(numbers, mid + 1, right);
        merge(numbers, left, mid, right);
    }

    private void merge(int[] numbers, int left, int mid, int right) {
        int[] tmpArr = new int[right - left + 1];
        int indexA = left;
        int indexB = mid + 1;

        for (int i = 0; i < right - left + 1; i++) {
            if (indexA > mid) {
                tmpArr[i] = numbers[indexB];
                indexB++;
            } else if (indexB > right) {
                tmpArr[i] = numbers[indexA];
                indexA++;
            } else if (numbers[indexA] > numbers[indexB]) {
                tmpArr[i] = numbers[indexB];
                indexB++;
            } else {
                tmpArr[i] = numbers[indexA];
                indexA++;
            }
        }
        for (int i = 0; i < tmpArr.length; i++) {
            numbers[left + i] = tmpArr[i];
        }
    }
}