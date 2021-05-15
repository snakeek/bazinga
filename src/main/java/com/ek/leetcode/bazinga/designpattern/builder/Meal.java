package com.ek.leetcode.bazinga.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2021
 * FileName: Meal
 * Author:   renyc
 * Date:     2021/5/15 4:31 下午
 * Description:
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        items.stream().forEach((Item item) -> {
            System.out.println("name : " + item.name());
            System.out.println("packing : " + item.packing().pack());
            System.out.println("price : " + item.price());
        });
    }
}