package com.ek.leetcode.bazinga;

/**
 * Copyright (C), 2019-2021
 * FileName: Type
 * Author:   renyc
 * Date:     2021/10/26 2:46 下午
 * Description:
 */
public class Type {

    public static void main(String[] args) {
        Type t = new Type();
        t.setType(-1);
        System.out.println(t.getTypeString());
        t.setType(1);
        System.out.println(t.getTypeString());
    }

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeString() {
        switch (type) {
            case 0:
                return "ZERO";
            case 1:
                return "ONE";
            default:
                return "OTHER";
        }
    }
}