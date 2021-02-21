package com.ek.leetcode.bazinga;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AATest {

    private static int COUNTER = 2;

    public static void main(String[] args) throws Exception {
        //12345
        //12354
        //13435
        //12453
        String start = "2020-03-31 17:05:56";
        String end = "2021-03-30 17:05:56";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 天数
        long dates = (sdf.parse(end).getTime() - sdf.parse(start).getTime()) / (1000 * 3600 * 24);

        // 计算每天平均确认金额
        Long aveAmount =  3500000 / dates;
        Long after = 4200000 / dates;
        Long eight = 1011800 / dates;
        System.out.println(dates);
        System.out.println(aveAmount);
        System.out.println(after);
        System.out.println(eight);

        Long aan = null;
        //System.out.println(aan.intValue());


        System.out.println("========");
        sortArr(new int[]{1,0,1,0,1,2,1,0,2});
    }

    private int compareNext(int number, int time) {

        int temp = number % time;
        int[] numArr = new int[COUNTER];
        int index = 0;
        for (int i = 10; i<= time; i*=10) {
            numArr[index] = temp % 10;
            temp = temp / 10;
            index++;
        }

       return -1;
    }

    private Integer[] getNumberArray(int number) {
        List<Integer> list = new ArrayList<>();
        while (number / 10 != 0) {
            list.add(number % 10);
            number /= 10;
        }
        return list.toArray(new Integer[]{});
    }

    public static void sortArr(int[] nums) {
        int zeroCounter = 0;
        for (int i = nums.length - 1; i >= 0; i-- ) {
            if (nums[i] == 0) {
                zeroCounter++;
            } else {
                nums[i+zeroCounter] = nums[i];
                if (i != (nums.length - 1)) {//最右侧是非0
                    nums[i] = 0;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums: " + nums[i]);
        }
    }
}
