package com.prosayj.springboot.spring_threadpool_taskexecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/11 0:51
 * @since 1.0.0
 */
@Component
public class _Test {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

}
