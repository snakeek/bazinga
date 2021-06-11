package com.ek.leetcode.bazinga.leetcode.binary.base;

import com.ek.leetcode.bazinga.btree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历就是逐层遍历树结构。
 * 广度优先搜索是一种广泛运用在树或图这类数据结构中，遍历或搜索的算法。
 * 该算法从一个根节点开始，首先访问节点本身。 然后遍历它的相邻节点，其次遍历它的二级邻节点、三级邻节点，以此类推。
 * Personal
 * Created by snakeek on 2018/5/28.
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> returnList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            queue = levelTraversal(queue, returnList);
        }
        return returnList;
    }

    private Queue<TreeNode> levelTraversal(Queue<TreeNode> nowLevel, List<List<Integer>> list) {
        Queue<TreeNode> nextLevel = new LinkedList<>();
        List<Integer> levelList = new ArrayList<>();
        while (!nowLevel.isEmpty()) {
            TreeNode treeNode = nowLevel.poll();
            levelList.add(treeNode.getVal());
            if (treeNode.getLeft() != null) {
                nextLevel.offer(treeNode.getLeft());
            }
            if (treeNode.getRight() != null) {
                nextLevel.offer(treeNode.getRight());
            }
        }
        list.add(levelList);
        return nextLevel;
    }
}
