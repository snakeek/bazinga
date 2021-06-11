package com.ek.leetcode.bazinga.rpc;

import com.ek.leetcode.bazinga.rpc.center.CenterServer;
import com.ek.leetcode.bazinga.rpc.center.CenterServerImpl;
import com.ek.leetcode.bazinga.rpc.consumer.RPCClient;
import com.ek.leetcode.bazinga.rpc.provider.HelloService;
import com.ek.leetcode.bazinga.rpc.provider.HelloServiceimpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Personal
 * Created by snakeek on 2017/7/13.
 */
public class RPCTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CenterServer serviceServer = new CenterServerImpl(31234);
                    serviceServer.regist(HelloService.class, HelloServiceimpl.class);
                    serviceServer.start();
                    System.out.println("server start");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemotePorxyObj(HelloService.class, new InetSocketAddress("127.0.0.1", 31234));
        System.out.println(service.sayHi("ekek"));
    }
}
