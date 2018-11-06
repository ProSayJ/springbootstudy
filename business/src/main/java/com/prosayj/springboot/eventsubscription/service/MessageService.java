package com.prosayj.springboot.eventsubscription.service;

import com.prosayj.springboot.constants.LoggerModelEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author yangjian
 * @description
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/16 16:57
 * @since 1.0.0
 */
@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_BUSINESS.getModuleNickName());

    public void addByMessageData(String data) {
        logger.info("订阅者收到消息:{}",data);
    }
}
