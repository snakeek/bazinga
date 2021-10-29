package com.ek.leetcode.bazinga.mybatis.how.plugin.work;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2021
 * FileName: MybatisPluginTest
 * Author:   renyc
 * Date:     2021/10/14 4:54 下午
 * Description:
 */
public class MybatisPluginTest {

    public static void main(String[] args) {
        HelloService target = new HelloServiceImpl();
        Interceptor transactionInterceptor = new TransactionInterceptor();
        LoginInterceptor logInterceptor = new LoginInterceptor();
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(transactionInterceptor);
        interceptorChain.addInterceptor(logInterceptor);
        target = (HelloService) interceptorChain.pluginAll(target);
        target.sayHello();
    }
}