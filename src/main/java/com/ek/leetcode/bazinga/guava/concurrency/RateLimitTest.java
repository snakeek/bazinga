package com.ek.leetcode.bazinga.guava.concurrency;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by snakeek on 2018/9/12.
 * nothing to write
 */
@Slf4j
public class RateLimitTest {
    public static void main(String[] args) {
        testNoRateLimiter();
        testWithRateLimiter();
    }

    public static void testNoRateLimiter() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println("call execute.." + i);

        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void testWithRateLimiter() {

        //每秒产生5个令牌
        RateLimiter limiter = RateLimiter.create(5.0);

        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            // 请求RateLimiter, 超过permits会被阻塞
            if (limiter.tryAcquire(20)) {
                log.info("call execute.. {}", i);
            } else {
                log.info("can not get limiter token {}", i);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                log.error("", e);
            }
        }
        Long end = System.currentTimeMillis();
        log.info("cost : {}", end - start);
    }
}