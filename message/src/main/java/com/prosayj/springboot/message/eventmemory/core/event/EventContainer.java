package com.prosayj.springboot.message.eventmemory.core.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @description 事件容器
 * @author yangjian
 * @Date 16:23 2018/9/20
 * @param null
 * @since 1.0.0
 */

public class EventContainer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private EventType eventType;

    /**
     * 一个事件有多人订阅
     */
    private List<EventHandlerUnit> eventHandlers = new ArrayList<>();

    public EventContainer(EventType eventType) {
        this.eventType = eventType;
    }

    /**
     * 订阅事件
     *
     * @param order        事件响应时的排序优先级
     * @param eventHandler
     */
    public void subscribe(int order, IEventHandler<?, ?> eventHandler) {
        synchronized (this) {
            this.eventHandlers.add(new EventHandlerUnit(eventHandler, order));

            Collections.sort(this.eventHandlers, new Comparator<EventHandlerUnit>() {
                @Override
                public int compare(EventHandlerUnit unit1, EventHandlerUnit unit2) {
                    if (unit2.getHandleOrder() < unit1.getHandleOrder()) {
                        return 1;
                    }
                    if (unit2.getHandleOrder() >= unit1.getHandleOrder()) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void publish(IEvent<?, ?> event) {
        synchronized (this) {
            Iterator<EventHandlerUnit> iterator = this.eventHandlers.iterator();
            while (iterator.hasNext()) {
                IEventHandler eventHandler = null;
                try {
                    eventHandler = iterator.next().getEventHandler();
                    eventHandler.handle(event.getSource(), event.getData());

                } catch (Exception e) {
                    logger.error("event handle failed. event type:{}, handler:{}, error: {}",
                            this.eventType, eventHandler.getClass().getName(), e.getMessage(), e);
                }
            }
        }
    }
}