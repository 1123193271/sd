package com.study.xyl._03_cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetClass.class);
        enhancer.setCallback(new MyMethodInterceptor());

        // 创建代理对象
        TargetClass proxyObject = (TargetClass) enhancer.create();

        // 调用代理对象的方法
        proxyObject.doSomething();
    }
}
