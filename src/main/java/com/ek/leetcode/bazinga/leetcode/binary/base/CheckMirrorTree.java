package com.ek.leetcode.bazinga.leetcode.binary.base;

import com.ek.diy.leetcode.binary.TreeNode;

/**
 * Personal
 * Created by snakeek on 2018/5/28.
 */
public class CheckMirrorTree {

    public boolean isSymmetric(TreeNode root) {
        return root == null || checkMirror(root.getLeft(), root.getRight());
    }

    private boolean checkMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else
            return left.getVal() == right.getVal() && checkMirror(left.getLeft(), right.getRight()) && checkMirror(left.getRight(), right.getLeft());
    }
}
