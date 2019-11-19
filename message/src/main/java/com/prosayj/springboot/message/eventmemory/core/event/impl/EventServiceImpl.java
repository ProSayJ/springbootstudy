package com.prosayj.springboot.message.eventmemory.core.event.impl;

import com.prosayj.springboot.message.eventmemory.core.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author yangjian
 * @description
 * @Date 16:22 2018/9/20
 * @since 1.0.0
 */
//@Service
public class EventServiceImpl implements IEventService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<EventType, EventContainer> eventContainers = new EnumMap<>(EventType.class);

    @Override
    public void subscribe(EventType eventType, IEventHandler<?, ?> eventHandler, int order) {
        synchronized (this.eventContainers) {
            EventContainer container = this.eventContainers.get(eventType);
            if (null == container) {
                container = new EventContainer(eventType);
                this.eventContainers.put(eventType, container);
            }
            container.subscribe(order, eventHandler);
        }
    }

    @Override
    public void publish(IEvent<?, ?> event) {
        EventContainer container = this.eventContainers.get(event.getType());
        if (null == container) {
            logger.error("event container not found. event type: {}", event.getType());
            return;
        }
        container.publish(event);
    }

}
