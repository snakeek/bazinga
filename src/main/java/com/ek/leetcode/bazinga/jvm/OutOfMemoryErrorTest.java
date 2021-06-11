package com.ek.leetcode.bazinga.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snakeek on 2017/8/26.
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemroyError
 */
@Slf4j
public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {

    }
}
