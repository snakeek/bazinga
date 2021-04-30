package com.ek.leetcode.bazinga.array.rookie;

import java.util.Arrays;

/**
 * Copyright (C), 2019-2021
 * FileName: FindSumTargetNumber
 * Author:   renyc
 * Date:     2021/2/18 3:07 下午
 * Description:
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9i1x6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindSumTargetNumber {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] res = twoSum(numbers, 9);
        Arrays.stream(res).forEach(System.out::println);

        System.out.println("====");
        numbers = new int[]{2, 3, 4};
        res = twoSum(numbers, 6);
        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}