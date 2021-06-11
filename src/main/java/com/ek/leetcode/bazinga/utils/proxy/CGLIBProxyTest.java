package com.ek.leetcode.bazinga.utils.proxy;


import com.ek.leetcode.bazinga.utils.proxy.service.TestService;

/**
 * Created by snakeek on 2017/7/9.
 */
public class CGLIBProxyTest {
    public static void main(String[] args) {
        TestService service = new TestServiceImpl();
        System.out.println(service.getClass().getSimpleName());
        TestService proxyService = (TestService) CGLIBProxy.getProxyObject(service);
        System.out.println(proxyService.getClass().getSuperclass());
        proxyService.saySomething("sdfsdf");
    }
}
