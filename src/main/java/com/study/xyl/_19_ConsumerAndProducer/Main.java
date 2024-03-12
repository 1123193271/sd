package com.study.xyl._19_ConsumerAndProducer;

public class Main {
    public static void main(String[] args) {
        // 店铺运营
        // 创建一个工厂
        Factory f = new Factory();

        // 招三个成产员工
        Producer p1 = new Producer(f);
        Producer p2 = new Producer(f);
        Producer p3 = new Producer(f);

        new Thread(p1, "工作人员A").start();
        new Thread(p2, "工作人员B").start();
        new Thread(p3, "工作人员C").start();

        // 引入三个消费者
        Sale s1 = new Sale(f);
        Sale s2 = new Sale(f);
        Sale s3 = new Sale(f);

        new Thread(s1, "消费者A").start();
        new Thread(s2, "消费者B").start();
        new Thread(s3, "消费者C").start();
    }
}
