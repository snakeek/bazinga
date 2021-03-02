package com.ek.leetcode.bazinga.tryatry;

import com.ek.leetcode.bazinga.btree.TreeNode;

public class SameParentBTree {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.getVal() == p.getVal() || root.getVal() == q.getVal()) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode right = lowestCommonAncestor(root.getRight(), p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null?right:left;
    }
}
