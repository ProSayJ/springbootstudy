
package com.prosayj.springboot.message.eventmemory.core.event.data.messageevent;


import com.prosayj.springboot.message.eventmemory.core.event.EventType;
import com.prosayj.springboot.message.eventmemory.core.event.IEvent;

/**
 * @author yangjian
 * @description
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/29 14:13
 * @since 1.0.0
 */
public class MessageEvent implements IEvent<Long, MessageEventData> {
    private long sendUserId;
    private MessageEventData messageEventData;

    public MessageEvent(long sendUserId, MessageEventData messageEventData) {
        this.sendUserId = sendUserId;
        this.messageEventData = messageEventData;
    }

    @Override
    public EventType getType() {
        return EventType.MESSAGE_NOTICE;
    }

    @Override
    public MessageEventData getData() {
        return messageEventData;
    }

    @Override
    public Long getSource() {
        return sendUserId;
    }
}
