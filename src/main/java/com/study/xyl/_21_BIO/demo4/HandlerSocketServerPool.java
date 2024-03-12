package com.study.xyl._21_BIO.demo4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSocketServerPool {
    private ExecutorService executorService;

    public HandlerSocketServerPool (int maxThreadNum, int queueSize) {
        executorService = new ThreadPoolExecutor(3, maxThreadNum, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable target) {
        executorService.execute(target);
    }
}
