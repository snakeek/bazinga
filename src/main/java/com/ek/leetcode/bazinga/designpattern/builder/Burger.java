package com.ek.leetcode.bazinga.designpattern.builder;

/**
 * Copyright (C), 2019-2021
 * FileName: Burger
 * Author:   renyc
 * Date:     2021/5/15 1:48 下午
 * Description:
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}