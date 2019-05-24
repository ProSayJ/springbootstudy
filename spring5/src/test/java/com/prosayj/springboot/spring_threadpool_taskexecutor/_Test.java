package com.prosayj.springboot.spring_threadpool_taskexecutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/11 0:51
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MultiThreadConfig.class})
public class _Test {
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    @Test
    public void test() {
        int n = 20;
        for (int i = 0; i < n; i++) {
            taskExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "===>hhah");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

