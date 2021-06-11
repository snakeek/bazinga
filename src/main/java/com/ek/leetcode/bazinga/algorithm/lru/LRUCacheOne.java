package com.ek.leetcode.bazinga.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Personal
 * Created by snakeek on 2018/3/29.
 */
public class LRUCacheOne<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_CACHE_SIZE;

    public LRUCacheOne(int cacheMaxSize, float loadFactor, boolean accessOrder) {
        super(cacheMaxSize, loadFactor, accessOrder);
        MAX_CACHE_SIZE = cacheMaxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }
}
