package com.study.xyl._14_volatileExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileExample {
    public volatile static boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while(!flag) {
                log.info("线程A处理事务");
            }
            log.info("线程A处理完毕");
        },"线程A").start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag = true;
            log.info("线程B设置flag变量值为true");
        },"线程B").start();
    }
}

