package com.study.xyl._19_ConsumerAndProducer;

import java.util.Vector;

public class Factory {
    Vector<Product> vc = new Vector<>();

    // 专门定义一个生产数据方法
    public synchronized void put(Product product) {
        // 判断产品于目标数量是否相同
        if (vc.size() >= 20) {
            // 产品数量满足让工作人员处于等待状态
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 让等待的工作人员生产产品
            this.notifyAll();
            System.out.println("正在生产中...当前货架的鸡脚数目是：" + vc.size());
            vc.add(product);
            System.out.println("货架鸡脚总数目是：" + vc.size());
            System.out.println(Thread.currentThread().getName() + "生产产品");
        }
    }

    // 专门定义一个负责消费数据方法
    public synchronized void sale() {
        // 只要容器存在货物就可以进行购买
        if (vc.size() > 10) {
            this.notifyAll(); // 唤醒所有等待的消费者
            System.out.println("当前货架上的鸡脚数目是:" + vc.size() + ",正在出售鸡脚。");
            vc.remove(0);
            System.out.println("\t目前货架上的鸡脚数目是：" + vc.size());
            System.out.println(Thread.currentThread().getName() + "消费产品");
        } else {
            // 没有鸡脚，让消费者处于等待状态
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
