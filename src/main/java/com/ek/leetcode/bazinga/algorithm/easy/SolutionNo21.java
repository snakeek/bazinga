package com.ek.leetcode.bazinga.algorithm.easy;

import com.ek.leetcode.bazinga.list.ListNode;

/**
 * Copyright (C), 2019-2020
 * FileName: SolutionNo21
 * Author:   renyc
 * Date:     2020/9/5 8:54 下午
 * Description:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class SolutionNo21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        while (true) {
            if (l1 == null && l2 == null) {
                return head.next;
            }
            if (l1 == null) {
                head.next = l2;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                head.next = l1;
                l1 = l1.next;
                continue;
            }
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
        }
    }
}