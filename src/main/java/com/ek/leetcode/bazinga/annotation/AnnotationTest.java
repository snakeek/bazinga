package com.ek.leetcode.bazinga.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snakeek on 2018/6/26.
 */
public class AnnotationTest {
    public static void main(String[] args) {
//        FruitsUtil.getFruitInfo(Apple.class);
        List<String> list = new ArrayList<>();
        list.add("aaa");
        System.out.println(list.get(0));
        StringBuilder sb = new StringBuilder();

        String aa = sb.append("日涨幅达到0.01").append("%").toString();
        System.out.println(aa);

        String a = "abcd";
        String b = "abcd";
        System.out.println(a.contains(b));
    }
}
