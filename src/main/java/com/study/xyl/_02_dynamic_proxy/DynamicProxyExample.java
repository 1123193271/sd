package com.study.xyl._02_dynamic_proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] args) {
        //Create a new real object
        Myinterface realObject = new MyClass();

        //create the proxy handler
        MyProxyHandler myProxyHandler = new MyProxyHandler(realObject);

        //Use proxy class to create proxy object
        Myinterface proxyObject = (Myinterface) Proxy.newProxyInstance(
          realObject.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(),
                myProxyHandler
        );

        //Calling a method on a proxy object actually triggers the invoke method of the proxy processor
        proxyObject.doSomething();

    }
}
