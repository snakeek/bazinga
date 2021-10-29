package com.ek.leetcode.bazinga.mybatis.how.plugin.work;

/**
 * Copyright (C), 2019-2021
 * FileName: Interceptor
 * Author:   renyc
 * Date:     2021/10/14 5:03 下午
 * Description:
 */
public interface Interceptor {
    Object interceptor(Invocation invocation) throws Exception;

    Object plugin(Object target);
}
