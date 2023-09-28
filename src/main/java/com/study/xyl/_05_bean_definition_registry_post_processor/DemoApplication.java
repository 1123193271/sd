package com.study.xyl._05_bean_definition_registry_post_processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.study.xyl._05_bean_definition_registry_post_processor");
        Apple apple = context.getBean(Apple.class);
        System.out.println(apple);
        Orange orange = context.getBean(Orange.class);
        System.out.println(orange);

    }
}
