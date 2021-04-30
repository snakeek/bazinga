package com.ek.leetcode.bazinga.algorithm.easy;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

/**
 * Copyright (C), 2019-2020
 * FileName: SolutionNo563
 * Author:   renyc
 * Date:     2020/9/4 6:42 下午
 * Description:
 * 给定一个二叉树，计算整个树的坡度。
 * <p>
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 */
public class SolutionNo563 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.setLeft(t2);
        t1.setRight(null);
        t2.setLeft(t3);
        t2.setRight(t4);
//        t3.setLeft(t5);
        SolutionNo563 s = new SolutionNo563();
        System.out.println(s.findTilt(t1));
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        return getTiltAndSumNodeVal(root)[0];
    }

    private int[] getTiltAndSumNodeVal(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int val = node.val;
        int[] arrLeft = getTiltAndSumNodeVal(node.left);
        int[] arrRight = getTiltAndSumNodeVal(node.right);

        return new int[]{arrLeft[0] + arrRight[0] + Math.abs(
                arrLeft[1] - arrRight[1]), val + arrLeft[1] + arrRight[1]};
    }
}