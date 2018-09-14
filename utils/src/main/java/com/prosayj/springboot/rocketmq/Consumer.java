package com.prosayj.springboot.rocketmq;

import com.prosayj.springboot.constants.LoggerModelEnum;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/13 17:25
 * @since 1.0.0
 */
public class Consumer {

    public static final Logger loger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_UTILS.getModuleNickName());

    public static void main(String[] args) throws InterruptedException, MQClientException {

        //指定一个Consumer Group 来创建一个consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

        //指定NameServer 地址,consumer和NameServer建立长链接,并且获取topic信息以及broker的ip和地址
        consumer.setNamesrvAddr("127.0.0.1:9876");
        //指定消费offset的位置。TIMESTAMP表示从consumer建立后,producer向broker新发送的消息开始
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        //指定消费topic,和过滤的TAG
        consumer.subscribe("group_01_topic_01", "*");
        //注册一个回调函数,当comsumer接收到消息时,执行的动作
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
//                System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
                loger.info("接收到消息：{}+{}", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动comsumer实例
        consumer.start();
        loger.info("Consumer Started.%n");
    }
}

