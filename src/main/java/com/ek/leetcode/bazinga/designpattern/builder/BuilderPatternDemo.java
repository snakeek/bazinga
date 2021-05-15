package com.ek.leetcode.bazinga.designpattern.builder;

/**
 * Copyright (C), 2019-2021
 * FileName: BuilderPatternDemo
 * Author:   renyc
 * Date:     2021/5/15 4:40 下午
 * Description:
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg meal!");
        vegMeal.showItems();
        System.out.println("Total cost : " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}