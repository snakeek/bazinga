package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.btree.TreeNodeSP;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Copyright (C), 2019-2021
 * FileName: ConnectBTree
 * Author:   renyc
 * Date:     2021/2/18 7:22 下午
 * Description:
 */
public class ConnectBTree {

    public static void main(String[] args) {
        //输入：root = [1,2,3,4,5,6,7]
        //输出：[1,#,2,3,#,4,5,6,7,#]
        TreeNodeSP root = new TreeNodeSP(1);
        root.left = new TreeNodeSP(2);
        root.right = new TreeNodeSP(3);
        root.left.left = new TreeNodeSP(4);
        root.left.right = new TreeNodeSP(5);
//        root.right.left = new TreeNodeSP(6);
        root.right.left = null;
        root.right.right = new TreeNodeSP(7);
//        connect(root);
        System.out.printf("===");
        connectHard(root);
        System.out.println("====");
    }

    public static TreeNodeSP connect(TreeNodeSP root) {
        if (root == null) {
            return root;
        }
        connectNode(root.left, root.right);
        return root;
    }

    private static void connectNode(TreeNodeSP left, TreeNodeSP right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        right.next = null;
        connectNode(left.left, left.right);
        connectNode(left.right, right.left);
        connectNode(right.left, right.right);
    }

    public static TreeNodeSP connectHard(TreeNodeSP root) {
        if (root == null) {
            return root;
        }
        int level = 0;
        int count;
        Queue<TreeNodeSP> queue = new LinkedBlockingQueue<>();
        if (root.left != null) {
            queue.add(root.left);
            level++;
        }
        if (root.right != null) {
            queue.add(root.right);
            level++;
        }
        TreeNodeSP head;
        while (!queue.isEmpty()) {
            count = level;
            level = 0;
            head = null;
            while (count > 0) {
                TreeNodeSP tmp = queue.poll();
                count--;
                if (tmp == null) {
                    continue;
                }
                if (head == null) {
                    head = tmp;
                } else {
                    head.next = tmp;
                    head = tmp;
                }
                if (head.left != null) {
                    queue.add(head.left);
                    level++;
                }
                if (head.right != null) {
                    queue.add(head.right);
                    level++;
                }
            }
        }
        return root;
    }
}