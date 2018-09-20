/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.eventsubscription;

import com.prosayj.eventsubscription.handler.MessageEventHandler;
import com.prosayj.eventsubscription.handler.MsgHandler;
import com.prosayj.springboot.event.eventcore.event.IEventHandler;
import com.prosayj.springboot.event.eventcore.event.IEventService;
import com.prosayj.springboot.event.eventcore.moduleinit.AbstractModuleInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangjian
 * @description 消息订阅类
 * @email yangjian@bubi.cn
 * @creatTime 2018/2/1 16:09
 * @since 1.0.0
 */
@Component
public class MessageSubscription extends AbstractModuleInit {

    @Autowired
    private IEventService eventService;
    @Autowired
    private MessageEventHandler messageEventHandler;
    @Autowired
    private MsgHandler msgHandler;

    @Override
    public void moduleInit() {
    }


    @Override
    public IEventService getEventService() {
        return eventService;
    }

    /**
     * 订阅之前先注册到容器
     * @return
     */
    @Override
    public IEventHandler<?, ?>[] registerEventHandlers() {
        return new IEventHandler[]{
                msgHandler
        };
    }

}
