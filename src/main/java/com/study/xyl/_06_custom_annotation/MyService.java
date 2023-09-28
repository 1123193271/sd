package com.study.xyl._06_custom_annotation;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void customServiceMethod() {
        //这里执行自定义的逻辑
        System.out.println("Custom service method is called.");
    }
}
