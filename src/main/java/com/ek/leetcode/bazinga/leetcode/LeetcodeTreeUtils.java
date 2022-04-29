package com.ek.leetcode.bazinga.leetcode;

import com.ek.leetcode.bazinga.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), 2019-2022
 * FileName: LeetcodeTreeUtils
 * Author:   renyc
 * Date:     2022/1/18 上午11:20
 * Description:
 */
public class LeetcodeTreeUtils {

    public static TreeNode makeTree(Integer[] trees) {
        int i = 1;
        int levelCount = 1;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(trees[0]);
        queue.add(root);
        while (!queue.isEmpty() && i <trees.length) {
            TreeNode node = queue.poll();
            count++;
            if (node == null) {
                continue;
            }
            TreeNode subNodeLeft = trees[i]==null?null:new TreeNode(trees[i]);
            i++;
            TreeNode subNodeRight = trees[i]==null?null:new TreeNode(trees[i]);
            node.left = subNodeLeft;
            node.right = subNodeRight;
            queue.offer(subNodeLeft);
            queue.offer(subNodeRight);
            if (count == levelCount) {
                count = 0;
                levelCount *= 2;
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = makeTree(new Integer[]{1,2,2,3,3,null,null,4,4});
        System.out.println(root.val);
    }
}