package com.ek.leetcode.bazinga.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by snakeek on 2018/10/29.
 */
public class MySupplierInterfaceTest {

    public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> resultList = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            resultList.add(supplier.get());
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list = supply(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
    }
}
