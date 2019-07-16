package com.prosayj.springbootstudy.config;

import com.prosayj.springbootstudy.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
*   指明当前类是一个配置文件，就是来替代之前的Sping配置文件
*
*   在配置文件中用<bean></bean>标签添加组件
* */
@Configuration
public class MyAppConfig {

    // 将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloServie() {
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}