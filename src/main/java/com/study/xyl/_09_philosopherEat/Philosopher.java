package com.study.xyl._09_philosopherEat;

import lombok.extern.slf4j.Slf4j;


@Slf4j(topic = "z.Philosopher")
public class Philosopher extends Thread {
    private Chopstick left;
    private Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            if (left.tryLock()) {
                try {
                    if (right.tryLock()) {
                       try {
                           eat();
                       } catch (InterruptedException e) {
                           log.error(e.getMessage());
                       } finally {
                           right.unlock();
                       }
                    }
                } finally {
                    left.unlock();
                }
            }
        }
    }
    private void eat() throws InterruptedException {
        log.debug("eating...");
        Thread.sleep(500);
    }

}
