package com.study.xyl._23_JUC;

import java.io.IOException;

public class InterruptDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread a = new Thread(() -> {
            System.out.println("thread a start to run!");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("在50秒之内按任意键中断线程!");
        a.start();
        System.in.read();
        a.interrupt();
        a.join();
        System.out.println("线程已经退出!");

    }
}
