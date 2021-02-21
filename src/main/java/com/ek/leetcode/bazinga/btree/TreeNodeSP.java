package com.ek.leetcode.bazinga.btree;

/**
 * Copyright (C), 2019-2021
 * FileName: TreeNodeSP
 * Author:   renyc
 * Date:     2021/2/18 7:23 下午
 * Description:
 */
public class TreeNodeSP {
    public int val;
    public TreeNodeSP left;
    public TreeNodeSP right;
    public TreeNodeSP next;

    public TreeNodeSP() {}

    public TreeNodeSP(int _val) {
        val = _val;
    }

    public TreeNodeSP(int _val, TreeNodeSP _left, TreeNodeSP _right, TreeNodeSP _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}