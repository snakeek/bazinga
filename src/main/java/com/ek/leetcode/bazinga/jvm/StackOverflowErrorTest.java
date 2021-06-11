package com.ek.leetcode.bazinga.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by snakeek on 2017/8/26.
 * VM Args: -Xss128k
 */
@Slf4j
public class StackOverflowErrorTest {
    private int stackLength = 1;

    public static void main(String[] args) throws Exception {
        StackOverflowErrorTest stack = new StackOverflowErrorTest();
        try {
            stack.stackLeak();
        } catch (Exception e) {
            log.info("\nstack length : {}", stack.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
