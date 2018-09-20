package com.prosayj.springboot.event.eventcore.event;

/**
 * @description 事件接口
 * @author yangjian
 * @Date 16:24 2018/9/20
 * @since 1.0.0
 */
public interface IEvent<S, V> {
    /**
     * 获取事件类型
     * @return
     */
    EventType getType();

    /**
     * 获取事件携带的数据
     * @return
     */
    V getData();

    /**
     * 获取事件源
     * @return
     */
    S getSource();}
