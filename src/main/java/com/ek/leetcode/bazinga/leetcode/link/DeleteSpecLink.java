package com.ek.leetcode.bazinga.leetcode.link;

/**
 * Personal
 * Created by snakeek on 2018/5/22.
 */
public class DeleteSpecLink {
    public static void main(String[] args) {

    }

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}