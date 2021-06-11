package com.ek.leetcode.bazinga.btree.bestopt;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snakeek on 2018/8/31.
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        list(root, returnList);
        return returnList;
    }

    private void list(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list(node.getLeft(), list);
        list(node.getRight(), list);
        list.add(node.getVal());
    }
}
