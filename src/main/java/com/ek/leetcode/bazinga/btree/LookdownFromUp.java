package com.ek.leetcode.bazinga.btree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Personal
 * Created by snakeek on 2018/5/30.
 */
public class LookdownFromUp {

    private static final Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> lookTree(TreeNode root) {

        map.put(0, root.getVal());
        System.out.println("value is : " + root.getVal());
//        levelTraversal(root.left, -1);
//        levelTraversal(root.right, 1);
        levelTraversal(root, 0);
        List<Integer> list = new ArrayList<>();
        System.out.println("count : " + map.size());
        list.addAll(map.values());
        return list;
    }

    private void levelTraversal(TreeNode node, int symbol) {
        if (!map.containsKey(symbol)) {
            System.out.println("value is : " + node.getVal());
            map.put(symbol, node.getVal());
        }
        if (node.left != null) {
            levelTraversal(node.left, symbol - 1);
        }
        if (node.right != null) {
            levelTraversal(node.right, symbol + 1);
        }
    }

    @Test
    public void testTraversal() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftl = new TreeNode(4);
        TreeNode leftr = new TreeNode(5);
        TreeNode rightl = new TreeNode(6);
        TreeNode rightr = new TreeNode(7);
        TreeNode rightrl = new TreeNode(8);
        TreeNode rightrll = new TreeNode(9);
        TreeNode rightrlll = new TreeNode(10);
        TreeNode rightrllll = new TreeNode(11);
        root.left = left;
        root.right = right;
        left.left = leftl;
        left.right = leftr;
        right.left = rightl;
        right.right = rightr;
        rightr.left = rightrl;
        rightrl.left = rightrll;
        rightrll.left = rightrlll;
        rightrlll.left = rightrllll;

        LookdownFromUp lookdownFromUp = new LookdownFromUp();
        List<Integer> list = lookdownFromUp.lookTree(root);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
