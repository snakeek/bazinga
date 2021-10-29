package com.ek.leetcode.bazinga.mybatis.how.plugin.work;

/**
 * Copyright (C), 2019-2021
 * FileName: TransactionInterceptor
 * Author:   renyc
 * Date:     2021/10/14 5:06 下午
 * Description:
 */
public class TransactionInterceptor implements Interceptor {
    @Override
    public Object interceptor(Invocation invocation) throws Exception {
        System.out.println("some logic after invode!");
        Object result = invocation.process();
        System.out.println("some logic before invoke!");
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return MyInvocationHandler.warp(target, this);
    }
}