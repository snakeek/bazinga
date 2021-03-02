package com.ek.leetcode.bazinga.list;

import com.ek.leetcode.bazinga.ListNode;

/**
 * Copyright (C), 2019-2021
 * FileName: CommonList
 * Author:   renyc
 * Date:     2021/2/22 5:10 下午
 * Description: 1
 */
public class CommonList {
    public static void main(String[] args) {
//        输入：l1 = [1,2,4], l2 = [1,3,4]
//        输出：[1,1,2,3,4,4]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode tmp = mergeTwoLists(l1, l2);
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }

//        输入：l1 = [2,4,3], l2 = [5,6,4]
//        输出：[7,0,8]
//        解释：342 + 465 = 807.

//        输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        输出：[8,9,9,9,0,0,0,1]

        ListNode ll = new ListNode(1);
        ll.next = new ListNode(2);
//        ll.next.next = new ListNode(3);
//        ll.next.next.next = new ListNode(4);
//        ll.next.next.next.next = new ListNode(5);
        removeNthFromEnd(ll, 2);
        System.out.println("==");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = null;
        ListNode node = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
                continue;
            } else if (l2 == null) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
                continue;
            }

            if (l1.val > l2.val) {
                if (newHead == null) {
                    newHead = l2;
                    node = l2;
                } else {
                    node.next = l2;
                    node = node.next;
                }
                l2 = l2.next;
            } else {
                if (newHead == null) {
                    newHead = l1;
                    node = l1;
                } else {
                    node.next = l1;
                    node = node.next;
                }
                l1 = l1.next;
            }
        }
        return newHead;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode node = head;
        int add = 0;
        int sum;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + add;
            if (head == null) {
                head = new ListNode(sum%10);
                node = head;
            } else {
                node.next = new ListNode(sum%10);
                node = node.next;
            }
            add = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2 != null) {
            sum = l2.val + add;
            node.next = new ListNode(sum%10);
            node = node.next;
            add = sum/10;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + add;
            node.next = new ListNode(sum%10);
            node = node.next;
            add = sum/10;
            l1 = l1.next;
        }
        if (add > 0) {
            node.next = new ListNode(add);
        }
        return head;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int res = findFromEnd(head, n);
        if (res == 0) {
            return head.next;
        }
        return head;
    }

    private static int findFromEnd(ListNode node, int n) {
        int res;
        if (node.next != null) {
            res = findFromEnd(node.next, n);
            if (res == 0) {
                node.next = node.next.next;
            }
        } else {
            res = n;
        }

        return (res-1);
    }

    static ListNode front;
    public static boolean isPalindrome(ListNode head) {
        front = head;
        return checkNode(front);
    }

    private static boolean checkNode(ListNode node) {
        if (node == null) {
            return true;
        }
        boolean res = checkNode(node.next)&&node.val == front.val;
        front = front.next;
        return res;
    }

    public static boolean isPalindromeNormal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        //fast slow pointer
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}