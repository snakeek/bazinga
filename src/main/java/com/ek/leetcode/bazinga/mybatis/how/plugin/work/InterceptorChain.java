package com.ek.leetcode.bazinga.mybatis.how.plugin.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (C), 2019-2021
 * FileName: InterceptorChain
 * Author:   renyc
 * Date:     2021/10/14 7:59 下午
 * Description:
 */
public class InterceptorChain {
    private List<Interceptor> interceptorList = new ArrayList<>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptorList) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
    }

    public List<Interceptor> getInterceptorList() {
        return Collections.unmodifiableList(interceptorList);
    }
}