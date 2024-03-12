package com.study.xyl._19_ConsumerAndProducer;

public class Sale implements Runnable{

    Factory f;
    public Sale(Factory f) {
        this.f = f;
    }

    @Override
    public void run() {
        while (true) {
            // 让消费者延迟购买的时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.sale();
        }
    }
}
