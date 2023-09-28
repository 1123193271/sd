package com.study.xyl._06_custom_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLoggerAspect {
    @Before("@annotation(customLogger)")
    public void logBefore(JoinPoint joinPoint, CustomLogger customLogger) {
        String methodName = joinPoint.getSignature().getName();
        String description = customLogger.value();
        System.out.println("Before executing " + methodName + ": " + description);
    }

    @AfterReturning(value = "@annotation(customLogger)", returning = "result")
    public void logAfter(JoinPoint joinPoint, CustomLogger customLogger, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String description = customLogger.value();
        System.out.println("After executing " + methodName + ": " + description);
        System.out.println("Method result: " + result);
    }
}
