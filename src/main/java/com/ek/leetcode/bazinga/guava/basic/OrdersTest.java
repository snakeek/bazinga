package com.ek.leetcode.bazinga.guava.basic;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by snakeek on 2018/9/20.
 */
public class OrdersTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(15);
        numbers.add(51);
        numbers.add(53);
        numbers.add(35);
        numbers.add(45);
        numbers.add(32);
        numbers.add(43);
        numbers.add(16);

        System.out.println("Input List: ");
        System.out.println(numbers);

        Ordering<Integer> ordering = Ordering.natural();
        Collections.sort(numbers, ordering);
        System.out.println("Sorted List: ");
        System.out.println(numbers);

        System.out.println("======================");
        System.out.println("List is sorted: " + ordering.isOrdered(numbers));
        System.out.println("Minimum: " + ordering.min(numbers));
        System.out.println("Maximum: " + ordering.max(numbers));

        Collections.sort(numbers, ordering.reverse());
        System.out.println("Reverse: " + numbers);

        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        Collections.sort(numbers, ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");

        List<String> names = new ArrayList<>();
        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add(null);
        names.add("Vikas");
        names.add("Deepak");

        System.out.println("Another List: ");
        System.out.println(names);

        Ordering<String> strOrdering = Ordering.natural();
        Collections.sort(names, strOrdering.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(names);
    }
}
