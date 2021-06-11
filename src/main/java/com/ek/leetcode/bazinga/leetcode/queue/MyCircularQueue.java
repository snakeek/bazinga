package com.ek.leetcode.bazinga.leetcode.queue;

/**
 * Created by snakeek on 2018/12/5.
 */
public class MyCircularQueue {

    private Integer[] datas;
    private int head;
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        datas = new Integer[k];
        head = -1;
        tail = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (head == -1 && tail == -1) {
            head = 0;
            tail = 0;
            datas[tail] = value;
            return true;
        }
        if (tail + 1 > datas.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        datas[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        if (head + 1 > datas.length - 1) {
            head = 0;
            return true;
        }
        head++;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return 0;
        }
        return datas[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return 0;
        }
        return datas[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return (head == -1 && tail == -1);
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1 == head) || ((tail == (datas.length - 1)) && head == 0);
    }

    public static void main(String[] args) {
        //["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
        //[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
        MyCircularQueue queue = new MyCircularQueue(6);
        queue.enQueue(6);
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        queue.deQueue();
        queue.enQueue(5);
        System.out.println(queue.Rear());
        queue.deQueue();
        System.out.println(queue.Front());
        queue.deQueue();
        queue.deQueue();
    }
}
