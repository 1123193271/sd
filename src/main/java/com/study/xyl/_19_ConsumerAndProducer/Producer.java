package com.study.xyl._19_ConsumerAndProducer;

public class Producer implements Runnable{
    Factory f;

    public Producer(Factory f) {
        this.f = f;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 调用生产数据的方法
            f.put(new Product(1, "鸡脚"));
        }
    }
}
