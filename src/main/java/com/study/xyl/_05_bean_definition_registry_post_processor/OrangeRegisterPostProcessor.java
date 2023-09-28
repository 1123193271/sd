package com.study.xyl._05_bean_definition_registry_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrangeRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry in OrangeRegisterPostProcessor started.");
        if (!beanDefinitionRegistry.containsBeanDefinition("orange")) {

            BeanDefinition orangeDefinition = BeanDefinitionBuilder.genericBeanDefinition(Orange.class).getBeanDefinition();

            beanDefinitionRegistry.registerBeanDefinition("orange", orangeDefinition);

        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory in OrangeRegisterPostProcessor started.");
    }
}
