package com.prosayj.springboot.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/10 19:41
 * @since 1.0.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={
        "com.prosayj.springboot",
})
public class ProsayjAutoConfig {
}
