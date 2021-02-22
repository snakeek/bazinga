package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Copyright (C), 2019-2021
 * FileName: CommonBTree
 * Author:   renyc
 * Date:     2021/2/19 2:48 下午
 * Description: 1
 */
public class CommonBTree {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> rootSet = new HashSet<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
    }

    private static int traval(TreeNode root, TreeNode p, TreeNode q, Stack<TreeNode> stackP, Stack<TreeNode> stackQ) {
        if (root == null) {
            return -1;
        }
        stackP.add(root);
        stackQ.add(root);
        if (root.getVal() == q.getVal()) {
            return 1;
        }
        if (root.getVal() == q.getVal()) {
            return 2;
        }
        int result = traval(root.getLeft(), p, q, stackP, stackQ);


    }
}