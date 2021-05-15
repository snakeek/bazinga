package com.ek.leetcode.bazinga.designpattern.builder;

/**
 * Copyright (C), 2019-2021
 * FileName: Item
 * Author:   renyc
 * Date:     2021/5/15 1:46 下午
 * Description:
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}