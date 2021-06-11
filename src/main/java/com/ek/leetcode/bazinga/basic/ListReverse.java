package com.ek.leetcode.bazinga.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Personal
 * Created by snakeek on 2018/4/6.
 */
public class ListReverse {

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 9; i > 0; i--) {
            numList.add(i);
        }
        System.out.println(numList);
        System.out.println("after reverse : ");
        System.out.println(getReverseList(numList));
    }

    private static List getReverseList(List oldList) {
        if (oldList == null) {
            return new ArrayList();
        }
        if (oldList.size() <= 1) {
            return oldList;
        }

        List newList = new ArrayList();
        newList.add(oldList.get(oldList.size() - 1));
        newList.addAll(getReverseList(oldList.subList(0, oldList.size() - 1)));
        return newList;
    }
}
