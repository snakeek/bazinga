package com.ek.leetcode.bazinga.leetcode;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

/**
 * Copyright (C), 2019-2022
 * FileName: Leetcode_0235
 * Author:   renyc
 * Date:     2022/1/13 下午4:42
 * Description:
 */
public class Leetcode_0235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }

        return left==null?right:left;
    }

    public static void main(String[] args) {

    }
}