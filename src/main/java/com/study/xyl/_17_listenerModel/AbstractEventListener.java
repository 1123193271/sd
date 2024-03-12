package com.study.xyl._17_listenerModel;

public class AbstractEventListener implements EventListener{

    /**
     * 监听器顺序
     */
    private int order;

    public int getOrder() {
        return order;
    }

    public AbstractEventListener(int order) {
        this.order = order;
    }

    @Override
    public void onTestEvent(Event event) {

    }
}
