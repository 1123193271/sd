package com.study.xyl._05_bean_definition_registry_post_processor;

import org.springframework.stereotype.Component;

@Component
public class Apple extends Fruit{
    @Override
    public String toString() {
        return "Apple{" +
                "type='" + type + '\'' +
                '}';
    }
}
