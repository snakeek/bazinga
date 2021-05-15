package com.ek.leetcode.bazinga.designpattern.builder;

/**
 * Copyright (C), 2019-2021
 * FileName: ColdDrink
 * Author:   renyc
 * Date:     2021/5/15 1:51 下午
 * Description:
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}