package com.study.xyl._23_JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> s = new FutureTask<>(() -> {
                    System.out.println("I am executing!");
                    return "I am from a Call";
                });
        new Thread(s).start();
        System.out.println("I am main Thread");
        System.out.println(s.get());
    }
}
