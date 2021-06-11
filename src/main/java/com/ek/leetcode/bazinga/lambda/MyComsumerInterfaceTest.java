package com.ek.leetcode.bazinga.lambda;

import java.util.function.Consumer;

/**
 * Created by snakeek on 2018/10/29.
 */
public class MyComsumerInterfaceTest {

    public static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    public static void main(String[] args) {
        donation(1000, money -> System.out.println("consume " + money + " unit"));
    }
}
