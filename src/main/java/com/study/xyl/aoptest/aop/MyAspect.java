package com.study.xyl.aoptest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.example.aoptest.service.MyService.*(..))")
    public void myPointcut() {
    }

    @Before("myPointcut()")
    public void beforeAdvice() {
        System.out.println("Before method execution...");
    }

    @After("myPointcut()")
    public void afterAdvice() {
        System.out.println("After method execution...");
    }

    @AfterReturning(pointcut = "myPointcut()", returning = "result")
    public void afterReturningAdvice (Object result) {
        System.out.println("Returning Result: " + result);
    }

    @AfterThrowing(pointcut = "myPointcut()", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("After throwing: " + exception.getMessage());
    }

    @Around("myPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around method execution(before)...");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("Around method execution(after)...");
        return result;
    }


}
