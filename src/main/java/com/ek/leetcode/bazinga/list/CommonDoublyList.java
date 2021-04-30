package com.ek.leetcode.bazinga.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2021
 * FileName: CommonDoublyList
 * Author:   renyc
 * Date:     2021/2/22 7:29 下午
 * Description: 1
 */
public class CommonDoublyList {

    public static void main(String[] args) {

    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        if (head.child != null) {

        }
        flatten(head.child);
        flatten(head.next);

        return null;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};