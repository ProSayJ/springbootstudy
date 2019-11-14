package com.prosayj.springboot.blog.core.common.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangjian
 * @description RabbitMqUtils
 * @Date 12:13 2019/5/13
 * @since 1.0.0
 */
@Component
public class RabbitMqUtils {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送到指定Queue
     *
     * @param queueName
     * @param obj
     */
    public void send(String queueName, Object obj) {
        this.rabbitTemplate.convertAndSend(queueName, obj);
    }
}
