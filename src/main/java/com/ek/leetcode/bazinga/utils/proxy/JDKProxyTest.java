package com.ek.leetcode.bazinga.utils.proxy;


import com.ek.leetcode.bazinga.utils.proxy.service.TestService;

/**
 * Created by snakeek on 2017/7/8.
 */
public class JDKProxyTest {
    public static void main(String[] args) throws Exception {
        TestService service = new TestServiceImpl();
        System.out.println(service.getClass().getSimpleName());
        TestService proxyStr = (TestService) JDKProxy.getProxyObject(service);
        System.out.println(proxyStr.getClass().getSuperclass());
        proxyStr.saySomething("sdfsdff");
    }
}
