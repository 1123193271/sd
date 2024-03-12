package com.study.xyl._13_InheritableThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("Main Value");
        Thread childrenThread = new Thread(() -> {
            String childrenValue = threadLocal.get();
            System.out.println("Children Name:"+Thread.currentThread().getName());
            System.out.println("Children Value:" + childrenValue);
        });
        childrenThread.start();

        try {
            childrenThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String mainValue = threadLocal.get();
        System.out.println("ThreadName:" + Thread.currentThread().getName());
        System.out.println("MainValue:" + threadLocal.get());


    }
}
