package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), 2019-2021
 * FileName: CommonBTree
 * Author:   renyc
 * Date:     2021/2/19 2:48 下午
 * Description: 1
 */
public class CommonBTree {

    public static void main(String[] args) {


//        输入：root = [1,2,3,null,null,4,5]
//        输出：[1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serialize(root));

//        [5,4,6,null,null,3,7]
        TreeNode test = new TreeNode(5);
        test.left = new TreeNode(4);
        test.right = new TreeNode(6);
        test.left.left = null;
        test.left.right = null;
        test.right.left = new TreeNode(3);
        test.right.right = new TreeNode(7);

        System.out.println("" + isValidBST(test));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.getVal() == p.getVal() || root.getVal() == q.getVal()) {
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

        return left == null?right:left;
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder str = new StringBuilder();
        str.append("[");
        int levelCount = 1;
        int count;
        TreeNode node;
        while (!queue.isEmpty()) {
            count = levelCount;
            while (count > 0) {
                node = queue.poll();
                if (node == null) {//TODO wrong!
                    str.append("null,");
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                    str.append(node.val).append(",");
                }
                count--;
            }
            levelCount *= 2;
        }
        String returnStr = str.toString();
        returnStr = returnStr.substring(0, returnStr.length()-1) + "]";
        return returnStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (min < node.val && node.val < max) {
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
        return false;
    }
}
