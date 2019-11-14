package com.prosayj.springboot.message.eventmemory.core.event;

/**
 * @author yangjian
 * @description
 * @Date 16:24 2018/9/20
 * @since 1.0.0
 */
public interface IEventService {

    /**
     * 订阅事件
     *
     * @param eventType
     * @param eventHandler
     * @param order        事件优先级
     */
    void subscribe(EventType eventType, IEventHandler<?, ?> eventHandler, int order);

    /**
     * 发布事件
     *
     * @param event
     */
    void publish(IEvent<?, ?> event);
}
