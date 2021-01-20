package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(null);
        root.setRight(new TreeNode(2));
        root.getRight().setLeft(new TreeNode(3));

        BTreeTraversal bTreeTraversal = new BTreeTraversal();
        bTreeTraversal.preOrderTraversal(root).stream().forEach(System.out::println);
        System.out.println("======");
        bTreeTraversal.inOrderTraversal(root).stream().forEach(System.out::println);
    }

    /**
     * 前序遍历 PreOrder
     * 根左右
     */
    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    /**
     * 前序遍历 PreOrder
     * 根左右
     * 递归
     */
    private void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.getVal());
        preOrderTraversal(root.getLeft(), list);
        preOrderTraversal(root.getRight(), list);
    }

    /**
     * 中序遍历 InOrder
     * 左根右
     */
    private List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft(), list);
        list.add(root.getVal());
        inOrderTraversal(root.getRight(), list);
    }

    /**
     * 后序遍历 PostOrder
     * 左右根
     */
    private List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return list;
    }
}
