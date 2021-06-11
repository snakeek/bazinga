package com.ek.leetcode.bazinga.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Personal
 * Created by snakeek on 2018/5/21.
 */
public class ThreeNumberSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        //a+b+c=0  -a=b+c
        int target, sum;
        for (int i = 0; i < nums.length - 2; i++) {
            target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                sum = nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    //bingo
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                }
            }
        }

        return null;
    }

    @Test(timeout = 1000)
    public void test() {
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    }
}
