package com.study.xyl._13_InheritableThreadLocal;

public class InheritableThreadLocalTest {
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("Main Thread Value");

        //创建新线程
        Thread childThread = new Thread(() -> {
            String value = inheritableThreadLocal.get();
            System.out.println("Child Thread Value: " + value);
        }, "ChildThreadWithInheritedValue");

        childThread.start();

        try {
            childThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String mainThreadValue = inheritableThreadLocal.get();
        System.out.println("Main Thread Value: " + mainThreadValue);
    }
}
