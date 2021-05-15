package com.ek.leetcode.bazinga.designpattern.builder;

/**
 * Copyright (C), 2019-2021
 * FileName: MealBuilder
 * Author:   renyc
 * Date:     2021/5/15 4:38 下午
 * Description:
 */
public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}