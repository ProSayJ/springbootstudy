package com.prosayj.springboot.event.eventcore.event.data.messageevent;

import com.prosayj.springboot.event.eventcore.event.EventType;
import com.prosayj.springboot.event.eventcore.event.IEvent;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/20 18:53
 * @since 1.0.0
 */
public class SimpleMsgEvent implements IEvent<String, String> {
    private String msg;

    public SimpleMsgEvent(String msg) {
        this.msg = msg;
    }

    @Override
    public EventType getType() {
        return EventType.MESSAGE_NOTICE;
    }

    @Override
    public String getData() {
        return msg;
    }

    @Override
    public String getSource() {
        return null;
    }

    @Override
    public String toString() {
        return "SimpleMsgEvent{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
