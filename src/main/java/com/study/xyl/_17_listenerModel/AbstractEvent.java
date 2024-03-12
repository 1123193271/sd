package com.study.xyl._17_listenerModel;

import lombok.Getter;

import java.util.EventObject;

public class AbstractEvent implements Event{

    @Getter
    private long timeStamp;

    private EventObject eventObject;

    public AbstractEvent(EventObject eventObject) {
        this.eventObject = eventObject;
    }

    @Override
    public EventObject getEventObject() {
        return eventObject;
    }

    @Override
    public void setEventObject(EventObject eventObject) {
        this.eventObject = eventObject;
        this.timeStamp = System.currentTimeMillis();
    }

}
