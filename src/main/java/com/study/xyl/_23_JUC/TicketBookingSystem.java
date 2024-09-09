package com.study.xyl._23_JUC;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingSystem {
    public static void main(String[] args) throws InterruptedException {
        TicketCounter ticketCounter = new TicketCounter(20);
        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticketCounter.purchaseTicket(1);
            }
        });
        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticketCounter.purchaseTicket(1);
            }
        });
        Thread th3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticketCounter.purchaseTicket(1);
            }
        });
        th1.setName("购票人1");
        th2.setName("购票人2");
        th3.setName("购票人3");

        th1.start();
        th2.start();
        th3.start();


    }
}
class TicketCounter{
    private final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public int getTickets() {
        return threadLocal.get();
    }

    public void setTickets(int tickets) {
        Integer i = threadLocal.get();
        threadLocal.set((i == null ? 0 : i) + tickets);
    }

    public void removeThickets() {
        threadLocal.remove();
    }


    //车票的剩余数量
    @Getter
    private int availableTickets;
    private final Lock lock = new ReentrantLock(true);

    public TicketCounter(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public void purchaseTicket(int quantity) {
        //加锁
        lock.lock();
        try {
            if (availableTickets >= quantity) {
                Thread.sleep(100);
                availableTickets -= quantity;
                setTickets(quantity);
                System.out.println(Thread.currentThread().getName() + "购买 " + quantity + "张票");
            } else {
                System.out.println(Thread.currentThread().getName() + "购买失败，数量不足");
                System.out.println(Thread.currentThread().getName() + "一共购买了" + threadLocal.get() + " 张");
                Thread.currentThread().interrupt();
                Thread.currentThread().join();

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //解锁
            lock.unlock();
        }
    }
}
