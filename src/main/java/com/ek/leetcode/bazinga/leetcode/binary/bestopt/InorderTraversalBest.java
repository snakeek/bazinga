package com.ek.leetcode.bazinga.leetcode.binary.bestopt;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snakeek on 2018/8/31.
 */
public class InorderTraversalBest {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        traversal(root, returnList);
        return returnList;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.getLeft(), list);
        list.add(node.getVal());
        traversal(node.getRight(), list);
    }
}
