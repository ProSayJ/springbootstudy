package com.prosayj.springboot.event.eventcore.event;


/**
 * @description 事件处理单元
 * @author yangjian
 * @Date 16:23 2018/9/20
 * @since 1.0.0
 */
public class EventHandlerUnit {

    private IEventHandler<?, ?> eventHandler;

    private int handleOrder;

    public EventHandlerUnit(IEventHandler<?, ?> eventHandler, int order) {
        this.handleOrder = order;
        this.eventHandler = eventHandler;
    }

    public IEventHandler<?, ?> getEventHandler() {
        return this.eventHandler;
    }

    int getHandleOrder() {
        return this.handleOrder;
    }

}
