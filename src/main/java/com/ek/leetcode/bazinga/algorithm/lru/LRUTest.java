package com.ek.leetcode.bazinga.algorithm.lru;

import java.util.LinkedHashMap;

/**
 * Personal
 * Created by snakeek on 2018/3/29.
 */
public class LRUTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> lruCache = new LRUCacheOne<>(5, 0.75f, true);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        System.out.println(lruCache);
        lruCache.get(3);
        lruCache.put(6, 6);
        System.out.println(lruCache);
        int a = lruCache.put(6, 9);
        System.out.println(a);
        a = lruCache.put(6, 11);
        System.out.println(a);
    }
}
