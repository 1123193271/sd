package com.study.xyl._17_listenerModel;

import java.util.EventObject;

public class Test3EventListener extends AbstractEventListener{

    public Test3EventListener(int order) {
        super(order);
    }
    @Override
    public void onTestEvent(Event event) {
        System.out.println("事件监听器3执行");

        //获取事件持有的对象
        EventObject eventObject = event.getEventObject();
        System.out.println(eventObject);
        //后续执行事件3的业务逻辑
    }
}
