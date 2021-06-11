package com.ek.leetcode.bazinga.annotation;

import java.lang.annotation.*;

/**
 * Created by snakeek on 2018/6/26.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    public enum Color {BLUE, RED, YELLOW}

    ;

    Color fruitColor() default Color.BLUE;
}
