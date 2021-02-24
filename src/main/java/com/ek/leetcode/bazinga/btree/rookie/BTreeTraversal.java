package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.btree.TreeNode;
import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
        System.out.println("======");
        bTreeTraversal.postOrderTraversal(root).stream().forEach(System.out::println);
        System.out.println("======");
        TreeNode levelRoot = new TreeNode(3);
        levelRoot.setLeft(new TreeNode(9));
        levelRoot.setRight(new TreeNode(20));
        levelRoot.getRight().setLeft(new TreeNode(15));
        levelRoot.getRight().setRight(new TreeNode(7));
        bTreeTraversal.levelOrder(levelRoot);
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
        postOrderTraversal(root, list);
        return list;
    }

    private void postOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeft(), list);
        postOrderTraversal(node.getRight(), list);
        list.add(node.getVal());
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Queue<TreeNode>> nodeQueue = new LinkedBlockingQueue<>();
        Queue<TreeNode> levelQueue = new LinkedBlockingQueue<>();
        levelQueue.add(root);
        nodeQueue.add(levelQueue);
        TreeNode node;
        Queue<TreeNode> tempQueue;
        Queue<TreeNode> nextLevelQueue = new LinkedBlockingQueue<>();
        while (!nodeQueue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            tempQueue = nodeQueue.poll();
            while (!tempQueue.isEmpty()) {
                node = tempQueue.poll();
                levelList.add(node.getVal());
                if (node.getLeft() != null) {
                    nextLevelQueue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextLevelQueue.add(node.getRight());
                }
            }
            list.add(levelList);
            if (nextLevelQueue.size() > 0) {
                nodeQueue.add(nextLevelQueue);
            }
            nextLevelQueue = new LinkedBlockingQueue<>();
        }
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.printf(" " + i + " ");
            }
            System.out.println("");
        }

        return list;
    }
}
