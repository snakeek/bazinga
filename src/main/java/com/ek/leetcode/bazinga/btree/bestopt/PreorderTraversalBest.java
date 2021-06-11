package com.ek.leetcode.bazinga.btree.bestopt;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by snakeek on 2018/8/31.
 */
public class PreorderTraversalBest {
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> rights = new Stack<>();
        while (node != null) {
            list.add(node.getVal());
            if (node.getRight() != null) {
                rights.push(node.getRight());
            }
            node = node.getLeft();
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }
}
