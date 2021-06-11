package com.ek.leetcode.bazinga.leetcode.binary;

import com.ek.leetcode.bazinga.leetcode.binary.base.InorderTraversal;
import com.ek.leetcode.bazinga.leetcode.binary.base.PostorderTraversal;
import com.ek.leetcode.bazinga.leetcode.binary.base.PreorderTraversal;
import com.ek.leetcode.bazinga.leetcode.binary.bestopt.PreorderTraversalBest;
import com.google.common.collect.Queues;

import java.util.List;
import java.util.Queue;

/**
 * test all binary algorithm
 * Created by snakeek on 2018/8/31.
 */
public class BinaryMain {

    public static void main(String[] args) {
        TreeNode tree = buildTree(new Integer[]{1, null, 2, 3});
        System.out.println("build tree complate!");

        List<Integer> list = new PreorderTraversal().preorderTraversal(tree);
        System.out.println("list is : " + list);
        list = new PreorderTraversalBest().preorderTraversal(tree);
        System.out.println("list is : " + list);

        list = new InorderTraversal().inorderTraversal(tree);
        System.out.println("list is : " + list);

        list = new PostorderTraversal().postorderTraversal(tree);
        System.out.println("list is : " + list);
    }

    private static TreeNode buildTree(Integer[] arr) {
        System.out.println("arr length : " + arr.length);
        int level = 2;
        int count = 1;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> nextNodeLevel = Queues.newLinkedBlockingQueue();
        Queue<TreeNode> nowNodeLevel = Queues.newLinkedBlockingQueue();
        nowNodeLevel.add(root);
        TreeNode levelNode = root;
        for (int i = 1; i < arr.length; i++) {
            if (count <= level) {
                if (arr[i] == null) {
                    count++;
                    continue;
                }
                TreeNode node = new TreeNode(arr[i]);

                if (count % 2 == 1) {
                    levelNode.left = node;
                } else {
                    levelNode.right = node;
                }
                nextNodeLevel.offer(node);
            } else if (count % 2 == 0) {
                levelNode = nowNodeLevel.poll();
            } else {
                nowNodeLevel = nextNodeLevel;
                level *= 2;
                nextNodeLevel = Queues.newLinkedBlockingQueue();
                count = 1;
                i--;
                levelNode = nowNodeLevel.poll();
                continue;
            }
            count++;
        }
        return root;
    }
}
