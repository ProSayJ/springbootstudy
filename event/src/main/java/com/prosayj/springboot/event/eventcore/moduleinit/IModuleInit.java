package com.prosayj.springboot.event.eventcore.moduleinit;

/**
 * @author yangjian
 * @description
 * @Date 16:25 2018/9/20
 * @since 1.0.0
 */
public interface IModuleInit {

    /**
     * 模块初始化
     */
    void init();

    /**
     * 模块初始化顺序
     *
     * @return
     */
    int order();

}
