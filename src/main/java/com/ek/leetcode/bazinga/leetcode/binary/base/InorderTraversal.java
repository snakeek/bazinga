package com.ek.leetcode.bazinga.leetcode.binary.base;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树
 * Personal
 * Created by snakeek on 2018/5/28.
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> returnList = new ArrayList<>();
        returnList.addAll(inorderTraversal(root.getLeft()));
        returnList.add(root.getVal());
        returnList.addAll(inorderTraversal(root.getRight()));
        return returnList;
    }
}
