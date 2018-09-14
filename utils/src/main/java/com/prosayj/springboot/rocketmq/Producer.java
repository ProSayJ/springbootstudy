package com.prosayj.springboot.rocketmq;

import com.prosayj.springboot.constants.LoggerModelEnum;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/13 15:59
 * @since 1.0.0
 */
public class Producer {
    public static final Logger loger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_UTILS.getModuleNickName());
    public static void main(String[] args) {
        // 创建一个Produer Group
        DefaultMQProducer producer = new DefaultMQProducer("group_01");
        // 指定NameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            // 启动producer
            producer.start();
            // 创建一个Message ,并指定topic、Tag和消息主体
            Message msg = new Message("group_01_topic_01", "group_01_topic_01_tags_01",
                    ("Hello RocketMQ~~~~ ").getBytes(RemotingHelper.DEFAULT_CHARSET));
            //向broker发送一个消息
            SendResult sendResult = producer.send(msg);
            loger.info("send mq, message:{}",sendResult);
        } catch (MQClientException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //当produer不再使用时,关闭produer
        producer.shutdown();
    }

}
