package com.ek.leetcode.bazinga.thread;

/**
 * Personal
 * Created by snakeek on 2018/4/6.
 */
public class Producer {

    public static final int MAX_PRODUCT = 5;
    public static final int MIN_PRODUCT = 0;
    private int product = 0;

    public synchronized void produce() {
        if (this.product >= MAX_PRODUCT) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        this.product++;
        System.out.println("produce product, Now total : " + this.product);
        notifyAll();
    }
}
