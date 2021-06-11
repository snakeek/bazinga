package com.ek.leetcode.bazinga.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created by snakeek on 2018/6/25.
 */
@Slf4j
public class ZkClientTest extends ZookeeperBase {
    public static void main(String[] args) {

        ZkClientTest firstTest = new ZkClientTest();
        ZkClient client = firstTest.createSession();
        String path = "/zk-java/first";
        client.createPersistent(path, true);
    }

    public ZkClient createSession() {
        ZkClient client = new ZkClient(ZOOKEEPER_DOMAIN, 5000);
        log.info("zookeeper session established.");
        return client;
    }
}
