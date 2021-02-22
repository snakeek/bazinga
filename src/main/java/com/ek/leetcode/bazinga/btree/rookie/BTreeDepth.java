package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.btree.TreeNode;

public class BTreeDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
        return depth + 1;
    }
}
