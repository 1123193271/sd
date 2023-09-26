package com.study.xyl._02_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyHandler implements InvocationHandler {

    private Object realOBject;

    public MyProxyHandler(Object realOBject) {
        this.realOBject = realOBject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Additional logic can be added before the method executes;
        System.out.println("Before the method execution.");
        //Invoke the real method
        Object result = method.invoke(realOBject, args);
        //Additional logic can be added before the method executes;
        System.out.println("After the method execution");

        return result;
    }

}
