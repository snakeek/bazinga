package com.ek.leetcode.bazinga.guava.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2019-2021
 * FileName: GuavaCaffeineTest
 * Author:   renyc
 * Date:     2021/10/15 11:04 上午
 * Description:
 */
public class GuavaCaffeineTest {

    public static void main(String[] args) {

        System.out.println("init appRiskConfigCache...");
        Cache<String, Integer> appRiskConfigCache = Caffeine.newBuilder().initialCapacity(1000).maximumSize(2000)
                .expireAfterWrite(10, TimeUnit.MINUTES).recordStats().build();

        Executors.newSingleThreadScheduledExecutor(runnable ->
                new Thread(runnable, "appRiskConfig-guavaCache-stat-thread"))
                .scheduleWithFixedDelay(() -> System.out.println("--------appRiskConfigCache size:" + appRiskConfigCache.stats().loadSuccessCount() + ",cacheHitCount:"
                        + appRiskConfigCache.stats().hitCount() + ",cacheHitRatio:" + appRiskConfigCache.stats().hitRate()
                        + "--------"), 2, 30, TimeUnit.SECONDS);

        System.out.println("init appRiskConfigCache complete! size " + appRiskConfigCache.stats().loadCount());

        System.out.println(appRiskConfigCache.get("aa", str-> 11));
        appRiskConfigCache.put("bb", null);
        System.out.println(appRiskConfigCache.getIfPresent("bb"));

        System.out.println("--------appRiskConfigCache size:" + appRiskConfigCache.stats().loadSuccessCount() + ",cacheHitCount:"
                + appRiskConfigCache.stats().hitCount() + ",cacheHitRatio:" + appRiskConfigCache.stats().hitRate()
                + "--------");
    }
}