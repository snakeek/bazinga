package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Copyright (C), 2019-2021
 * FileName: BTreePathCalculate
 * Author:   renyc
 * Date:     2021/2/18 1:44 下午
 * Description: 1
 */
public class BTreePathCalculate {

    public static void main(String[] args) {
        //root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        //true
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(8));
        root.getLeft().setLeft(new TreeNode(11));
        root.getLeft().setRight(null);
        root.getRight().setLeft(new TreeNode(13));
        root.getRight().setRight(new TreeNode(4));
        root.getLeft().getLeft().setLeft(new TreeNode(7));
        root.getLeft().getLeft().setRight(new TreeNode(2));
        System.out.println("result : " + hasPathSum(root, 22));

        root = new TreeNode(-2);
        root.setLeft(null);
        root.setRight(new TreeNode(-3));
        System.out.println("result : " + hasPathSum(root, -5));

        //[8,9,-6,null,null,5,9]
        //7
        root = new TreeNode(8);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(-6));
        root.getLeft().setLeft(null);
        root.getLeft().setRight(null);
        root.getRight().setLeft(new TreeNode(5));
        root.getRight().setRight(new TreeNode(9));
        System.out.println("result : " + hasPathSum(root, 7));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return preOrder(root, targetSum, 0);
    }

    private static boolean preOrder(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        sum += root.getVal();
        if (root.getLeft() == null && root.getRight() == null && sum == targetSum) {
            return true;
        }
        return preOrder(root.getLeft(), targetSum, sum) || preOrder(root.getRight(), targetSum, sum);
    }
}