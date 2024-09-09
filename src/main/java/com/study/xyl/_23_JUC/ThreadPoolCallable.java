package com.study.xyl._23_JUC;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolCallable {
    private final static AtomicInteger IDX = new AtomicInteger(0);

    private final static ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            1, 3, 5, TimeUnit.SECONDS, new SynchronousQueue<>(), r -> new Thread(r, "test-" + IDX.getAndIncrement()), new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> submit = THREAD_POOL_EXECUTOR.submit(() -> {
            String name = Thread.currentThread().getName();
            Thread.sleep(2000);
            return "我是"+name+"返回结果";
        });
        System.out.println(submit.get());
    }

}
