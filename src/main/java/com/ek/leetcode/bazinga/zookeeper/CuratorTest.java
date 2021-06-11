package com.ek.leetcode.bazinga.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class CuratorTest extends ZookeeperBase {

    private static final String LOCK_PATH = "/curator_lock_path";
    private static final String COUNTER_PATH = "/curator_distatomicint_path";

    static RetryPolicy policy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString(ZOOKEEPER_DOMAIN)
            .retryPolicy(policy).build();

    public static void main(String[] args) throws Exception {
        //使用Curator实现分布式锁
//        DistributedLock();
        //分布式计数器
        DistributedCounter();
    }

    /**
     * 使用Curator实现分布式锁
     */
    private static void DistributedLock() {
        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client, LOCK_PATH);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        lock.acquire();
                    } catch (Exception e) {
                        log.warn("exception", e);
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = sdf.format(new Date());
                    log.info("order No is : {}", orderNo);
                    try {
                        lock.release();
                    } catch (Exception e) {
                        log.warn("exception", e);
                    }
                }
            }).start();
        }
        countDownLatch.countDown();
        client.close();
    }

    /**
     * 分布式计数器
     */
    private static void DistributedCounter() {
        client.start();
        DistributedAtomicInteger atomicInteger = new DistributedAtomicInteger(client, COUNTER_PATH, new RetryNTimes(3, 1000));
        AtomicValue<Integer> rc = null;
        try {
            for (int i = 0; i < 3; i++) {
                rc = atomicInteger.add(8);
                log.info("result : {}", rc.succeeded());
            }
            rc = atomicInteger.get();
            log.info("result : {} {}", rc.preValue(), rc.postValue());
            log.info("");
        } catch (Exception e) {
            log.warn("exception", e);
        }
        client.close();
    }
}
