package com.ek.leetcode.bazinga.leetcode.binary.base;

import com.ek.diy.leetcode.binary.TreeNode;

/**
 * Personal
 * Created by snakeek on 2018/5/28.
 */
public class FindMaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.getLeft());
        int rightMaxDepth = maxDepth(root.getRight());
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }

}
