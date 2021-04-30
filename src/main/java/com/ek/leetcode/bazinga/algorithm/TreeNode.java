package com.ek.leetcode.bazinga.algorithm;

/**
 * Copyright (C), 2019-2020
 * FileName: TreeNode
 * Author:   renyc
 * Date:     2020/9/4 6:42 下午
 * Description: treenode
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}