package com.ek.leetcode.bazinga.lambda;

/**
 * Created by snakeek on 2018/10/29.
 */
public class MyOwnFunctionInterfaceTest {

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * 执行Predicate判断
     *
     * @param age       年龄
     * @param predicate Predicate函数式接口
     * @return 返回布尔类型结果
     */
    public static boolean doPredicate(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }

    public static void main(String[] args) {
        boolean isAdult = doPredicate(20, x -> x >= 18);
        System.out.println(isAdult);
    }
}
