package com.ek.leetcode.bazinga.querydsl;

import lombok.Data;
// needed for access of the Querydsl Collections API
import static com.querydsl.collections.CollQueryFactory.*;
// needed, if you use the $-invocations
import static com.querydsl.core.alias.Alias.*;

import java.util.List;

/**
 * Created by snakeek on 2018/9/14.
 */
public class CollectionsTest {
    public static void main(String[] args) {

        Cat c = alias(Cat.class, "cat");
//        for (String name : select($(c.getName())).from($(c), cats)).where() {

//        }
    }
}

@Data
class Cat {
    private String name;
    private List<Cat> kittens;
}
