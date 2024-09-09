package com.study.xyl._23_JUC;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolCallableCase1 {
    private final static AtomicInteger IDX = new AtomicInteger(0);

    private final static ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024),
            r -> new Thread(r, "open-api-" + IDX.getAndIncrement()), new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        ThreadPoolCallableCase1 threadPoolCallableCase1 = new ThreadPoolCallableCase1();
        System.out.println(threadPoolCallableCase1.getData());
    }

    public String getData() {
        Future<String> submit = THREAD_POOL_EXECUTOR.submit(() -> {
            try {
                Thread.sleep((long) (Math.random() * 4000));
            } catch (InterruptedException e) {
                System.out.println("任务被主动中断");
            }
            return "第三方数据返回成功";
        });
        try {
            return submit.get(3, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            return "第三方异常";
        } catch (InterruptedException e) {
            return "手动中断任务";
        } catch (TimeoutException e) {
            //超时了就取消任务
            System.out.println(submit.cancel(true));
            return "第三方接口网络超时";
        }
    }

}
