package com.study.xyl._03_cglib_proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 在目标方法调用前执行逻辑
        System.out.println("Before method execution");

        // 调用目标方法
        Object result = methodProxy.invokeSuper(object, args);

        // 在目标方法调用后执行逻辑
        System.out.println("After method execution");

        return result;
    }
}
