package com.ek.leetcode.bazinga.annotation;

import java.lang.annotation.*;

/**
 * Created by snakeek on 2018/6/26.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    public int id() default -1;

    public String name() default "";

    public String address() default "";
}
