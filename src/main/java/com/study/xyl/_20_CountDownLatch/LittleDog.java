package com.study.xyl._20_CountDownLatch;

public class LittleDog extends Dog{
    @Override
    public void eat() {
        System.out.println("Little dog eat.....");
    }

    public static void main(String[] args) {
        Dog littleDog = new LittleDog();
        littleDog.eat();
    }
}
