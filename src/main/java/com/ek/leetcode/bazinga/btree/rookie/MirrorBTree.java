package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Copyright (C), 2019-2021
 * FileName: MirrorBTree
 * Author:   renyc
 * Date:     2021/2/18 10:38 上午
 * Description: 1
 */
public class MirrorBTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().setRight(new TreeNode(3));

        if (isSymmetric(root)) {
            System.out.println("mirror!");
        } else {
            System.out.printf("not mirror!");
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return true;
        }
        return isSame(root.getLeft(), root.getRight());

    }

    private static boolean isSame(TreeNode left, TreeNode right) {
        return (left == null && right == null) || ((left != null && right != null) && left.getVal() == right.getVal() &&
                isSame(left.getLeft(), right.getRight()) &&
                isSame(left.getRight(), right.getLeft()));
    }
}