package com.ek.leetcode.bazinga.leetcode.binary.base;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历是先遍历左子树，然后遍历右子树，最后访问树的根节点
 * Personal
 * Created by snakeek on 2018/5/28.
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> returnList = new ArrayList<>();
        returnList.addAll(postorderTraversal(root.getLeft()));
        returnList.addAll(postorderTraversal(root.getRight()));
        returnList.add(root.getVal());
        return returnList;
    }
}
