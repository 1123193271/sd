package com.study.xyl._17_listenerModel;

import java.util.List;

public class EventMulticaster {
    private List<AbstractEventListener> listeners;

    public EventMulticaster(List<AbstractEventListener> listeners) {
        this.listeners = listeners;
    }

    public void multicastEvent(Event event) {
        for (AbstractEventListener listener : listeners) {
            listener.onTestEvent(event);
        }
    }
}
