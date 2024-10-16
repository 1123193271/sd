package com.study.xyl._20_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
                System.out.println("Task Completed by " + Thread.currentThread().getName());
            }).start();
        }
        countDownLatch.await();
        System.out.println("All Tasks Completed!");
    }
}
