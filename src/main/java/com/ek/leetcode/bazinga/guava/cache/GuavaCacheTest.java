package com.ek.leetcode.bazinga.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by snakeek on 2018/10/25.
 */
public class GuavaCacheTest {

    static final ListeningExecutorService backExecutor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    static final LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(10)
            .expireAfterAccess(3, TimeUnit.MINUTES)
//            .refreshAfterWrite(2, TimeUnit.SECONDS)
            .build(
                    new CacheLoader<String, String>() {
                        @Override
                        public String load(String key) throws Exception {
                            return "from load - " + key + " - " + System.currentTimeMillis();
                        }

//                        @Override
//                        public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
//                            return backExecutor.submit(new Callable<String>() {
//                                @Override
//                                public String call() throws Exception {
//                                    return "from reload - " + System.currentTimeMillis();
//                                }
//                            });
//                        }
                    });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(loadingCache.get("aa"));
        System.out.println(loadingCache.size());
        loadingCache.invalidateAll();
        loadingCache.getIfPresent("bb");
        loadingCache.getIfPresent("cc");
        loadingCache.getIfPresent("aa");
        System.out.println(loadingCache.size());

        Map<String, String> map = Maps.newHashMap();
        map.put("a", "b");
        String xx = map.get("c");
        if (xx == null) {
            System.out.println("is null");
        }

    }
}
