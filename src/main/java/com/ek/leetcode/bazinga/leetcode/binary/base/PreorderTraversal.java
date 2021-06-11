package com.ek.leetcode.bazinga.leetcode.binary.base;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树
 * Personal
 * Created by snakeek on 2018/5/28.
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> returnList = new ArrayList<>();
        returnList.add(root.getVal());
        if (root.getLeft() != null) {
            returnList.addAll(preorderTraversal(root.getLeft()));
        }
        if (root.getRight() != null) {
            returnList.addAll(preorderTraversal(root.getRight()));
        }
        return returnList;
    }
}
