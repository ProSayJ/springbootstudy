/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */
package com.prosayj.springboot.designmode.bulider.demo01;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description
 * @Date 11:31 2018/10/17
 * @since 1.0.0
 */
public class MessageData implements Serializable {

    private static final long serialVersionUID = 5262678484321297162L;

    private MessageData() {
    }


    /**
     * 发布者id
     */
    private Long publishUserId;
    /**
     * 发布者企业id
     */
    private Long publishCompanyId;
    /**
     * 订阅企业id
     */
    private Long subscriberCompanyId;

    /**
     * 消息内容(模板)
     */
    private String messageTemplate;

    /**
     * 事件内的消息类型
     */
    private MessageTypeEnum messageType;

    /**
     * 消息模板填充的内容
     */
    private Map<String, Object> data;

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    public Long getSubscriberCompanyId() {
        return subscriberCompanyId;
    }

    public void setSubscriberCompanyId(Long subscriberCompanyId) {
        this.subscriberCompanyId = subscriberCompanyId;
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static class Bulider {

        /**
         * 事件内的消息类型
         */
        private MessageTypeEnum messageType;
        /**
         * 发布者id
         */
        private Long publishUserId;
        /**
         * 发布者企业id
         */
        private Long publishCompanyId;
        /**
         * 通知数据
         */
        private Map<String, Object> data = new HashMap<>();


        public Bulider put(String key, Object value) {
            data.put(key, value);
            return this;
        }

        public Bulider setMessageType(MessageTypeEnum messageType) {
            this.messageType = messageType;
            return this;
        }

        public Bulider setPublishUserId(Long publishUserId) {
            this.publishUserId = publishUserId;
            return this;
        }

        public Bulider setPublishCompanyId(Long publishCompanyId) {
            this.publishCompanyId = publishCompanyId;
            return this;
        }

        public MessageData bulid() {
            if (data.isEmpty() || publishCompanyId == null || publishUserId == null || messageType == null) {
                throw new RuntimeException("参数错误");
            }
            MessageData messageData = new MessageData();
            messageData.setMessageType(messageType);
            messageData.setPublishCompanyId(publishCompanyId);
            messageData.setPublishUserId(publishUserId);
            messageData.setData(data);
            return messageData;
        }

    }

    @Override
    public String toString() {
        return "MessageData{" +
                "publishUserId=" + publishUserId +
                ", publishCompanyId=" + publishCompanyId +
                ", subscriberCompanyId=" + subscriberCompanyId +
                ", messageTemplate='" + messageTemplate + '\'' +
                ", messageType=" + messageType +
                ", data=" + data +
                '}';
    }
}
