package com.study.xyl._23_JUC;

import java.util.concurrent.*;

/**
 * 假设今天是周六，公司要求今天统一去公司集合，然后人到齐之后一起坐车去团建！！！
 * 要求所有员工必须先全部到公司集合，人到齐后再一块儿去目的地团建。
 */
public class CyclicBarrierDemo {
    private final static ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    /**
     * 小伙伴
     */
    private static final CyclicBarrier BUDDY_CUNT = new CyclicBarrier(4, () -> {
        System.out.println("人都到齐了，出发去团建");
        System.out.println("公司班车开始发往目的地。。。。");
        try {
            Thread.sleep((long) (Math.random() * 10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("两个小时后终于到目的地了");
    });

    /**
     * 员工
     */
    private static class  EmployeeAct implements Runnable {
        private final String name;

        private EmployeeAct(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + "出发前往公司");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(name + "到达公司");
                BUDDY_CUNT.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        EXECUTOR.execute(new EmployeeAct("打工人1号"));
        EXECUTOR.execute(new EmployeeAct("打工人2号"));
        EXECUTOR.execute(new EmployeeAct("打工人3号"));
        EXECUTOR.execute(new EmployeeAct("打工人4号"));
    }




}