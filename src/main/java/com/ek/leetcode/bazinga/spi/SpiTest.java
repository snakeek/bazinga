package com.ek.leetcode.bazinga.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by snakeek on 2018/9/30.
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<BookService> spiLoader = ServiceLoader.load(BookService.class);
        Iterator<BookService> iterator = spiLoader.iterator();
        while (iterator.hasNext()) {
            BookService bookService = iterator.next();
            bookService.printBookName();
        }
    }
}
