package com.study.xyl._01_aoptest.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void doSomething() {
        System.out.println("do something...");
    }

    public int divide(int a, int b) {
        return a / b;
    }
}
