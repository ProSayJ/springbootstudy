
package com.prosayj.eventsubscription.handler;

import com.prosayj.eventsubscription.service.MessageService;
import com.prosayj.springboot.event.eventcore.event.EventType;
import com.prosayj.springboot.event.eventcore.event.IEventHandler;
import com.prosayj.springboot.event.eventcore.event.data.messageevent.MessageEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangjian
 * @description 订阅以后处理事件类
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/29 14:19
 * @since 1.0.0
 */
@Component
public class MessageEventHandler implements IEventHandler<Long, MessageEventData> {
    @Autowired
    MessageService messageService;

    @Override
    public void handle(Long source, MessageEventData data) {
//        messageService.addByMessageData(data);
    }

    @Override
    public EventType getType() {
        return EventType.MESSAGE_NOTICE;
    }


}
