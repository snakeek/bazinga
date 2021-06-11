package com.ek.leetcode.bazinga.guava.collection;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * Created by snakeek on 2018/9/20.
 */
public class ImmutableTest {
    public static void main(String[] args) {
        try {
            immutableByJDK();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        immutableByGuava();
    }

    private static void immutableByJDK() throws UnsupportedOperationException {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        //get immutable list
        System.out.println(list);
        List<String> immutableList = Collections.unmodifiableList(list);
        System.out.println(immutableList);

        //fix old list
        list.add("d");
        System.out.println(list);
        System.out.println(immutableList);

        //try fix immutable list
        immutableList.add("e");
    }

    private static void immutableByGuava() {

    }
}
