package com.ek.leetcode.bazinga;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode temp = new ListNode(4);
        l1.next = temp;
//        temp = new ListNode(8);
//        l1.next.next = temp;

        ListNode l2 = new ListNode(5);
        temp = new ListNode(6);
        l2.next = temp;
        temp = new ListNode(4);
        l2.next.next = temp;

        Solution s = new Solution();
        ListNode n = s.addTwoNumbers(l1, l2);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }

        ListNode returnNode = null;
        ListNode index = null;
        int plus = 0;
        int temp = 0;
        while (true) {
            if (l1 != null && l2 != null) {
                temp = l1.val + l2.val + plus;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                temp = l1.val + plus;
                l1 = l1.next;
            } else if (l2 != null) {
                temp = l2.val + plus;
                l2 = l2.next;
            } else {
                break;
            }

            if (returnNode == null) {
                returnNode = new ListNode(temp % 10);
                index = returnNode;
            } else {
                index.next = new ListNode(temp % 10);
                index = index.next;
            }
            if (temp >= 10) {
                plus = temp / 10;
            } else {
                plus = 0;
            }
        }
        if (plus > 0) {
            index.next = new ListNode(plus);
        }
        return returnNode;
    }
}