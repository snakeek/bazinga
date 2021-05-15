package com.ek.leetcode.bazinga.designpattern.builder;

/**
 * Copyright (C), 2019-2021
 * FileName: VegBurger
 * Author:   renyc
 * Date:     2021/5/15 1:57 下午
 * Description:
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger!";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}