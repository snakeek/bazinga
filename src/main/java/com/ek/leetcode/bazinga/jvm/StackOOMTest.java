package com.ek.leetcode.bazinga.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by snakeek on 2017/8/26.
 * VM Args: -Xss2M
 */
@Slf4j
public class StackOOMTest {
    public static void main(String[] args) throws Exception {
        StackOOMTest stack = new StackOOMTest();
        stack.stackLeadByThread();
    }

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeadByThread() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }
}
