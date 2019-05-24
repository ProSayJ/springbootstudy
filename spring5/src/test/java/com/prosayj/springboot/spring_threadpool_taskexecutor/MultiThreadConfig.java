package com.prosayj.springboot.spring_threadpool_taskexecutor;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/24 18:45
 * @since 1.0.0
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = {"com.prosayj.springboot.spring_threadpool_taskexecutor"})
@ImportResource(value = {"classpath:com/prosayj/springboot/application-task.xml"})
@EnableScheduling
public class MultiThreadConfig {

}
