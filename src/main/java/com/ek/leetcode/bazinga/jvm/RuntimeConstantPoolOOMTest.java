package com.ek.leetcode.bazinga.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snakeek on 2017/8/26.
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOMTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
