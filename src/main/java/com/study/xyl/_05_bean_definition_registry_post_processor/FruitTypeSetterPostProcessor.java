package com.study.xyl._05_bean_definition_registry_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class FruitTypeSetterPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory in FruitTypeSetterPostProcessor started.");
        String[] fruitForType = configurableListableBeanFactory.getBeanNamesForType(Fruit.class);
        for (String name : fruitForType) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            beanDefinition.getPropertyValues().add("type", name);
        }
    }
}
