package com.prosayj.springboot.event.eventcore.event;

/**
 * @author yangjian
 * @description 事件类型
 * @Date 16:24 2018/9/20
 * @since 1.0.0
 */
public enum EventType {

    /**
     * 凭证融资申请
     */
    VOUCHER_FINANCING_APPLY,
    /**
     * 消息通知
     */
    MESSAGE_NOTICE,

    /**
     * 凭证兑付
     */
    VOUCHER_PAY,

    /**
     * 埋点
     */
    EVENT_TRACKING,

    ;
}
