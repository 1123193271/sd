package com.study.xyl._17_listenerModel;

import java.io.Serializable;
import java.util.EventObject;

public interface Event extends Serializable {

    EventObject getEventObject();

    void setEventObject(EventObject eventObject);
}
