package com.ek.leetcode.bazinga.annotation;


import lombok.Data;

/**
 * Created by snakeek on 2018/6/26.
 */
@Data
public class Apple {

    @FruitName(fruitName = "Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "a shop", address = "some address")
    private String appleProvider;
}
