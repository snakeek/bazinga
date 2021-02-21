package com.ek.leetcode.bazinga.btree.rookie;

import com.ek.leetcode.bazinga.btree.TreeNodeSP;

/**
 * Copyright (C), 2019-2021
 * FileName: ConnectBTree
 * Author:   renyc
 * Date:     2021/2/18 7:22 下午
 * Description:
 */
public class ConnectBTree {

    public static void main(String[] args) {

    }

    public TreeNodeSP connect(TreeNodeSP root) {
        if (root == null) {
            return root;
        }

    }

    private void connectNode(TreeNodeSP left, TreeNodeSP right) {
        left.next = right;

    }
}