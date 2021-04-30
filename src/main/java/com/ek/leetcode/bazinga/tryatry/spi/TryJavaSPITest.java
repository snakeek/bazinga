package com.ek.leetcode.bazinga.tryatry.spi;

import java.util.ServiceLoader;

/**
 * Copyright (C), 2019-2021
 * FileName: TryJavaSPITest
 * Author:   renyc
 * Date:     2021/3/10 2:33 下午
 * Description: 1
 */
public class TryJavaSPITest {

    public static void main(String[] args) {
        ServiceLoader<TryJavaSPI> tryJavaSPIS = ServiceLoader.load(TryJavaSPI.class);
        for (TryJavaSPI t : tryJavaSPIS) {
            t.doSomething("wow~");
        }
    }
}