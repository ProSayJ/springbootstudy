package com.prosayj.springboot.rocketmq.demo;

import org.apache.rocketmq.common.message.Message;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/14 15:12
 * @since 1.0.0
 */
public class RocketMQProducerTest {
    // mqbroker -n localhost:9876 autoCreateTopicEnable=true
    public static void main(String[] args) {

        String mqNameServer = "127.0.0.1:9876";
        String mqTopics = "MQ-MSG-TOPICS-TEST";

        String producerMqGroupName = "PRODUCER-MQ-GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();


        for (int i = 0; i < 5; i++) {
            Message message = new Message();
            message.setBody(("I send message to RocketMQ " + i).getBytes());
            mqProducer.send(message);
        }


    }

}