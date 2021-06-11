package com.ek.leetcode.bazinga.leetcode.binary;

import lombok.Data;

/**
 * Created by snakeek on 2018/8/31.
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
