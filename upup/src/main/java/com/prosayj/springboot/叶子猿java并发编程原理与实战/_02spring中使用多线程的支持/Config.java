package com.prosayj.springboot.叶子猿java并发编程原理与实战._02spring中使用多线程的支持;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 17:00
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.prosayj.springboot.叶子猿java并发编程原理与实战._02spring中使用多线程的支持")
//启动异步
@EnableAsync
public class Config {
}
