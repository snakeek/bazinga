package com.ek.leetcode.bazinga.rpc.center;

import java.io.IOException;

/**
 * Personal
 * Created by snakeek on 2017/7/11.
 */
public interface CenterServer {
    void stop();

    void start() throws IOException;

    void regist(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
