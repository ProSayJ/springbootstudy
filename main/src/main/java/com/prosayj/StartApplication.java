package com.prosayj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * （1）@Configuration：表名该类使用基于Java的配置,将此类作为配置类
 * （2）@ComponentScan：启用注解扫描
 * （3）@EnableAutoConfiguration：开启springboot的自动配置功能
 */
@SpringBootApplication(scanBasePackages = {
        "com.prosayj.springboot.api",
})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
