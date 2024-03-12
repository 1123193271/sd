package com.study.xyl._14_volatileExample;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class VolatileTest {
    private volatile int count;

    public void add() {
        count++;
    }

    @SneakyThrows
    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                volatileTest.add();
            }).start();
        }

        Thread.sleep(1000);
        log.info("count:{}", volatileTest.count);
    }

}
