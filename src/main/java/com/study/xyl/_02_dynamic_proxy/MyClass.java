package com.study.xyl._02_dynamic_proxy;

public class MyClass implements Myinterface{
    @Override
    public void doSomething() {
        System.out.println("Real object is doing something.");
    }
}
