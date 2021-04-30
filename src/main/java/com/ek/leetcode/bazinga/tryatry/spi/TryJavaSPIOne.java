package com.ek.leetcode.bazinga.tryatry.spi;

/**
 * Copyright (C), 2019-2021
 * FileName: TryJavaSPIOne
 * Author:   renyc
 * Date:     2021/3/10 2:30 下午
 * Description: 1
 */
public class TryJavaSPIOne implements TryJavaSPI {
    @Override
    public void doSomething(String method) {
        System.out.println("Hello : " + method);
    }
}