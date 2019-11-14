package com.prosayj.springboot.message.eventmemory.core.event;

/**
 * @author yangjian
 * @description 事件处理接口
 * @Date 16:24 2018/9/20
 * @since 1.0.0
 */
public interface IEventHandler<S, V> {

    /**
     * 事件处理
     *
     * @param source
     * @param data
     */
    void handle(S source, V data);

    /**
     * 事件类型
     *
     * @return
     */
    EventType getType();
}
