package com.ek.leetcode.bazinga.leetcode.binary.base;

import com.ek.diy.leetcode.binary.TreeNode;
import org.junit.Test;

/**
 * Personal
 * Created by snakeek on 2018/5/28.
 */
public class HasPathSum {

    //[5,4,8,11,null,13,4,7,2,null,null,null,1]
    //22
    public boolean hasPathSum(TreeNode root, int sum) {
        return checkSum(root, 0, sum);

    }

    private boolean checkSum(TreeNode node, int total, int sum) {
        if (node == null) {
            return false;
        }
        int nowTotal = total + node.getVal();
        if (nowTotal == sum && (node.getLeft() == null && node.getRight() == null)) {
            return true;
        } else {
            boolean flagLeft = checkSum(node.getLeft(), nowTotal, sum);
            boolean flagRight = checkSum(node.getRight(), nowTotal, sum);
            return flagLeft || flagRight;
        }
    }

    @Test
    public void testHasPathNum() {
        TreeNode root = new TreeNode(1);
        TreeNode l1_left = new TreeNode(2);
//        TreeNode l1_right = new TreeNode(8);
//        TreeNode l2_a_left = new TreeNode(11);
//        TreeNode l2_b_left = new TreeNode(13);
//        TreeNode l2_b_right = new TreeNode(4);
//        TreeNode l3_a_left = new TreeNode(7);
//        TreeNode l3_a_right = new TreeNode(2);
//        TreeNode l3_d_right = new TreeNode(5);
        root.setLeft(l1_left);
//        root.right = l1_right;
//        l1_left.left = l2_a_left;
//        l1_right.left = l2_b_left;
//        l1_right.right = l2_b_right;
//        l2_a_left.left = l3_a_left;
//        l2_a_left.right = l3_a_right;
//        l2_b_right.right = l3_d_right;
        if (hasPathSum(root, 1)) {
            System.out.println("has path");
        } else {
            System.out.println("no path");
        }
    }
}
