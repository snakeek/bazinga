package com.ek.leetcode.bazinga.annotation;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by snakeek on 2018/6/26.
 */
public class FruitsUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitName = "fruitName : ";
        String strFruitColor = "fruitColor : ";
        String strFruitProvider = "fruitProvider : ";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println(strFruitName + fruitName.fruitName());
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println(strFruitColor + fruitColor.fruitColor());
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider provider = field.getAnnotation(FruitProvider.class);
                System.out.println(strFruitProvider + provider.id() + " " + provider.name() + " " + provider.address());
            }
        }
    }
}
