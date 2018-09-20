package com.prosayj.springboot.event.eventcore.event.data.messageevent;



import com.prosayj.springboot.event.eventcore.event.constant.MessageTypeEnum;

import java.io.Serializable;
import java.util.Map;

/**
 * @author yangjian
 * @description
 * @Date 10:58 2018/2/6
 * @since 1.0.0
 */
public class MessageEventData implements Serializable {
    private static final long serialVersionUID = 1287645515704100934L;


    public MessageEventData(Long publishUserId, Long publishCompanyId, Long subscriberCompanyId, MessageTypeEnum messageType, Map<String, Object> data) {
        if (null == data || data.isEmpty()) {
//            throw new BusinessException(MessageErrorCodeEnum.PUBLISH_DATA_NOT_EXIST);
        } else {
//            data.put(MessageDataMapConstants.MESSAGE_TYPE, messageType);
        }
        this.publishUserId = publishUserId;
        this.publishCompanyId = publishCompanyId;
        this.data = data;
        this.messageType = messageType;
        this.subscriberCompanyId = subscriberCompanyId;
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
     * 消息模板填充的内容
     */
    private Map<String, Object> data;
    /**
     * 消息内容(模板)
     */
    private String messageTemplate;

    /**
     * 事件内的消息类型
     */
    private MessageTypeEnum messageType;

    public Long getPublishUserId() {
        return publishUserId;
    }

    private MessageEventData setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
        return this;
    }

    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    private MessageEventData setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public MessageEventData setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public MessageEventData setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
        return this;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    private void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getSubscriberCompanyId() {
        return subscriberCompanyId;
    }

    public void setSubscriberCompanyId(Long subscriberCompanyId) {
        this.subscriberCompanyId = subscriberCompanyId;
    }

    @Override
    public String toString() {
        return "MessageEventData{" +
                "publishUserId=" + publishUserId +
                ", publishCompanyId=" + publishCompanyId +
                ", subscriberCompanyId=" + subscriberCompanyId +
                ", data=" + data +
                ", messageTemplate='" + messageTemplate + '\'' +
                ", messageType=" + messageType +
                '}';
    }
}