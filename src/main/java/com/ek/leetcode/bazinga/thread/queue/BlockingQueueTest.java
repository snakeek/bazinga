package com.ek.leetcode.bazinga.thread.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Personal
 * Created by snakeek on 2017/7/17.
 */
public class BlockingQueueTest {
    //producer
    public static class Producer implements Runnable {
        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;
        private Random random;

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.flag = false;
            this.random = new Random();
        }

        @Override
        public void run() {
            while (!flag) {
                int info = random.nextInt(100);
                try {
                    System.out.println(Thread.currentThread().getName() + "=== producer queue size " + blockingQueue.size());
                    blockingQueue.put(info);
                    System.out.println(Thread.currentThread().getName() + "produce " + info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            this.flag = true;
        }
    }

    //consumer
    public static class Consumer implements Runnable {
        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.flag = false;
        }

        @Override
        public void run() {
            while (!flag) {
                int info;
                try {
                    System.out.println(Thread.currentThread().getName() + "=== consumer queue size " + blockingQueue.size());
                    info = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + "consume " + info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            this.flag = true;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        for (int i = 0; i < 3; i++) {
            if (i < 1) {
                new Thread(producer, "producer " + i).start();
            } else {
                new Thread(consumer, "consumer " + i).start();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.shutdown();
        consumer.shutdown();
    }
}
