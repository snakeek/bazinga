package com.ek.leetcode.bazinga.leetcode;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

/**
 * Copyright (C), 2019-2022
 * FileName: Leetcode_0110
 * Author:   renyc
 * Date:     2022/1/13 下午5:01
 * Description:
 */
public class Leetcode_0110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = getHeight(root.left, 0);
        int right = getHeight(root.right, 0);

        System.out.println("==== left " + left + "    ==== right " + right);
        return Math.abs(left-right) <2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node, int height) {
        if (node == null) {
            return height;
        }

        height++;

        int left = height;
        int right = height;
        if (node.left != null) {
            left = getHeight(node.left, height);
        }
        if (node.right != null) {
            right = getHeight(node.right, height);
        }

        System.out.println(node.val + "    " + height + "    " + left + "    " + right);
        return left>right?left:right;
    }



    public static void main(String[] args) {
        TreeNode root = LeetcodeTreeUtils.makeTree(new Integer[]{1,2,2,3,3,null,null,4,4});
        Leetcode_0110 test = new Leetcode_0110();
//        System.out.println(test.isBalanced(root));

//        root = LeetcodeTreeUtils.makeTree(new Integer[]{1,null,2,null,3});
//        System.out.println(test.isBalanced(root));

//        root = LeetcodeTreeUtils.makeTree(new Integer[]{3,9,20,null,null,15,7});
//        System.out.println(test.isBalanced(root));

        root = LeetcodeTreeUtils.makeTree(new Integer[]{1,2,2,3,null,null,3,4,null,null,4});
        System.out.println(test.isBalanced(root));
    }
}