package com.prosayj.springboot.message.eventmemory.core.moduleinit;


import com.prosayj.springboot.message.eventmemory.core.event.IEventHandler;
import com.prosayj.springboot.message.eventmemory.core.event.IEventService;

/**
 * @description
 * @author yangjian
 * @Date 16:25 2018/9/20
 * @since 1.0.0
 */
public abstract class AbstractModuleInit implements IModuleInit {

    @Override
    public void init() {

        // 注册事件
        IEventHandler<?, ?>[] eventHandlers = registerEventHandlers();
        if (null != eventHandlers) {
            for (IEventHandler<?, ?> handler : eventHandlers) {
                getEventService().subscribe(handler.getType(), handler, order());
            }
        }

        moduleInit();
    }

    @Override
    public int order() {
        return 200;
    }

    /**
     * 模块初始化，子模块实现
     */
    public abstract void moduleInit();

    /**
     * 获取 eventService
     *
     * @return
     */
    public abstract IEventService getEventService();

    /**
     * 注册事件响应
     *
     * @return
     */
    public abstract IEventHandler<?, ?>[] registerEventHandlers();

}
