package com.ek.leetcode.bazinga.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by snakeek on 2018/9/19.
 */
public class SemahporeTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            final int index = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("thread tasking : " + index);
                        Thread.sleep(index * 1000L);
                        System.out.println("thread over : " + index + "  |  avaliable semaphore : " + semaphore.availablePermits());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            executor.submit(task);
        }
        executor.shutdown();
    }
}
