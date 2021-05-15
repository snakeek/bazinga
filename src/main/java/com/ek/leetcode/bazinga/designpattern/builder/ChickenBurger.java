package com.ek.leetcode.bazinga.designpattern.builder;

/**
 * Copyright (C), 2019-2021
 * FileName: ChickenBurger
 * Author:   renyc
 * Date:     2021/5/15 1:59 下午
 * Description:
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chickken Burger!";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}