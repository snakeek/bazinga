package com.ek.leetcode.bazinga.leetcode;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

/**
 * Copyright (C), 2019-2022
 * FileName: Leetcode_0102
 * Author:   renyc
 * Date:     2022/1/11 下午8:34
 * Description:
 */
public class Leetcode_0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        boolean res = false;

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        res = hasPathSum(root.left, targetSum - root.val);
        if (!res) {
            res = hasPathSum(root.right, targetSum - root.val);
        }

        return res;
    }
}