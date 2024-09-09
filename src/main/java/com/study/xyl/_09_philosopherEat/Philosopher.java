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
//        while (true) {
//            if (left.tryLock()) {
//                try {
//                    if (right.tryLock()) {
//                       try {
//                           eat();
//                       } catch (InterruptedException e) {
//                           log.error(e.getMessage());
//                       } finally {
//                           right.unlock();
//                       }
//                    }
//                } finally {
//                    left.unlock();
//                }
//            }
//        }
        try{
            left.lock();
            //线程等待，这样会导致每个哲学家都占有自己左边的筷子，造成死锁问题
            Thread.sleep(100);
            right.lock();
            eat();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            left.unlock();
            right.unlock();
        }
    }
    private void eat() throws InterruptedException {
        log.debug("eating...");
        Thread.sleep(500);
    }

}
