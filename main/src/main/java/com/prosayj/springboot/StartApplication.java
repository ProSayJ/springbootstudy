package com.prosayj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * （1）@Configuration：表名该类使用基于Java的配置,将此类作为配置类
 * （2）@ComponentScan：启用注解扫描
 * （3）@EnableAutoConfiguration：开启springboot的自动配置功能
 */
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
