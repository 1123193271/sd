package com.study.xyl._05_bean_definition_registry_post_processor;

/**
 * 这里不添加@Component注解，这个bean会在OrangeRegisterPostProcessor 里动态创建。
 */
public class Orange extends Fruit{
    @Override
    public String toString() {
        return "Orange{" +
                "type='" + type + '\'' +
                '}';
    }
}
