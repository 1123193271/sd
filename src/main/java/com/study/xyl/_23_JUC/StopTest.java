package com.study.xyl._23_JUC;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class StopTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程正在运行");
            }
            return "运行完成";
        });
        new Thread(futureTask).start();
        Thread.sleep(1000);
        System.out.println(futureTask.cancel(true));
        System.out.println("任务被停止");
        System.out.println(futureTask.get());
    }
}

