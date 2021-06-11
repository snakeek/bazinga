package com.ek.leetcode.bazinga.leetcode;

import java.math.BigDecimal;

/**
 * Personal
 * Created by snakeek on 2018/5/21.
 */
public class LinkNumberSum {

    public static void main(String[] args) {
        ListNode a = getListNode(String.valueOf(9));
        ListNode b = getListNode(String.valueOf(9999999991L));
        ListNode result = addTwoNumbers(a, b);
        if (result == null) {
            System.out.println("result is null");
            return;
        }
        System.out.println(result.val);
        while (result.next != null) {
            result = result.next;
            System.out.println(result.val);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0;
        ListNode next1 = null;
        ListNode next2 = null;
        if (l1 != null && l2 != null) {
            value = l1.val + l2.val;
            next1 = l1.next;
            next2 = l2.next;
        } else if (l1 != null) {
            value = l1.val;
            next1 = l1.next;
        } else if (l2 != null) {
            value = l2.val;
            next2 = l2.next;
        }
        ListNode node = new ListNode(value % 10);
        int add = value / 10;
        node.next = getListNode(next1, next2, add);
        return node;
    }

    private static ListNode getListNode(ListNode l1, ListNode l2, int added) {
        int value;
        ListNode next1 = null;
        ListNode next2 = null;
        if (l1 != null && l2 != null) {
            value = l1.val + l2.val;
            next1 = l1.next;
            next2 = l2.next;
        } else if (l1 != null) {
            value = l1.val;
            next1 = l1.next;
        } else if (l2 != null) {
            value = l2.val;
            next2 = l2.next;
        } else if (added > 0) {
            return new ListNode(added);
        } else {
            return null;
        }
        value += added;
        ListNode node = new ListNode(value % 10);
        int add = value / 10;
        node.next = getListNode(next1, next2, add);
        return node;
    }

    private static ListNode getListNode(String number) {
        if (!"0".equals(number)) {
            BigDecimal[] num = new BigDecimal(number).divideAndRemainder(new BigDecimal(10));
            ListNode node = new ListNode(num[1].intValue());
            node.next = getListNode(num[0].toString());
            return node;
        } else {
            return null;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
