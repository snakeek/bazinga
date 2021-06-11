package com.ek.leetcode.bazinga.spi;

/**
 * Created by snakeek on 2018/9/30.
 */
public class MathBookService implements BookService {
    @Override
    public void printBookName() {
        System.out.println("math book!");
    }
}
