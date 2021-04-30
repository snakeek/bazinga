package com.ek.leetcode.bazinga.list;

import com.ek.leetcode.bazinga.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        ListNode newHead = reverseList(head);
//        while (newHead != null) {
//            System.out.println(newHead.val);
//            newHead = newHead.next;
//        }
        oddEvenList(head);
        System.out.println("===");
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseListAnother(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            if (head.val == val) {
                head = node.next;
                node = head;
            } else if (node.val == val) {
                prev.next = node.next;
                node = node.next;
            } else {
                prev = node;
                node = node.next;
            }
        }
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode dTail = null;
        ListNode sHead = head;
        ListNode dHead = null;
        int num = 1;

        while (curr.next != null) {
            num++;
            curr = curr.next;
            if (num % 2 == 1) {
                sHead.next = curr;
                sHead = sHead.next;
            } else {
                if (dHead == null) {
                    dHead = curr;
                    dTail = curr;
                } else {
                    dTail.next = curr;
                    dTail = dTail.next;
                }
            }
        }
        sHead.next = dHead;
        if (dTail != null) {
            dTail.next = null;
        }
        return head;
    }

    public static ListNode oddEvenListBest(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            oddHead.next = even.next;
            oddHead = oddHead.next;
            even.next = oddHead.next;
            even = even.next;
        }
        oddHead.next = evenHead;
        return head;
    }

    public static boolean isPalindrome(ListNode head) {
        //翻转
        //TODO
        ListNode slow = head;
        ListNode fast = head;
        return false;
    }

    ListNode p;//全局P用于回归时的正序

    public boolean check(ListNode node) {
        if (node == null) return true;//递归出口
        boolean res = check(node.next) && node.val == p.val;
        p = p.next;
        return res;
    }

    public boolean isPalindromeBest(ListNode head) {
        p = head;
        return check(head);
    }
}
