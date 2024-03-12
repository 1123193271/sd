package com.study.xyl._17_listenerModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EventObject;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<AbstractEventListener> listeners = new ArrayList<>(3);
//        listeners.add(new Test1EventListener(2));
//        listeners.add(new Test2EventListener(1));
//        listeners.add(new Test3EventListener(3));
//
//        listeners = listeners.stream().sorted(Comparator.comparing(AbstractEventListener::getOrder))
//                .collect(Collectors.toList());
//        //自定义的广播器
//        EventMulticaster eventMulticaster = new EventMulticaster(listeners);
//        //定义eventObject
//        EventObject eventObject = new EventObject("WX"+System.currentTimeMillis());
//        //广播事件
//        eventMulticaster.multicastEvent(new OrderCallbackEvent(eventObject));
//        User user = new User();
//        user.setName("lisi");
        String name = "ddd";
        modifyPrimitiveValue(name);
        System.out.println("After modifyPrimitiveValue: " + name); // 输出：After modifyPrimitiveValue: 42

    }

    static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static void modifyPrimitiveValue(String user) {
        user = "111";
    }
}