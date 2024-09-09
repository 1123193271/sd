package com.study.xyl._25_Copy;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeanCopyKit {

    public static void copyProperties(Object source, Object target) {
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(actualEditable);
        if (source instanceof Map<?,?>) {
            if (target instanceof Map<?,?>) {
                ((Map<?, ?>) target).putAll((Map) source);
            } else {
                Map<String, Object> map = (Map<String, Object>) source;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    PropertyDescriptor targetPd = org.springframework.beans.BeanUtils.getPropertyDescriptor(target.getClass(), key);
                    Method writeMethod = targetPd.getWriteMethod();
                }
            }
        }
        System.out.println(Arrays.toString(propertyDescriptors));

    }

    public static void main(String[] args) {
        ExamplePO examplePO = new ExamplePO();
        Map<String, String> example = new HashMap<>();
        example.put("id", "001");
        example.put("name", "小红");
        example.put("grade", "100分");
        example.put("age", "22");
        copyProperties(example, examplePO);
    }
}
