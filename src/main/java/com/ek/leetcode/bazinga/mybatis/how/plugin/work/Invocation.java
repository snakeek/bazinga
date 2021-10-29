package com.ek.leetcode.bazinga.mybatis.how.plugin.work;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2019-2021
 * FileName: Invocation
 * Author:   renyc
 * Date:     2021/10/14 5:41 下午
 * Description:
 */
public class Invocation {
    private Object target;
    private Method method;
    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object process() throws Exception {
        return method.invoke(target, args);
    }
}