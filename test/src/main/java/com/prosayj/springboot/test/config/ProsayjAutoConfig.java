package com.prosayj.springboot.test.config;

import com.prosayj.springboot.test.moduleinit.ModuleInitApplicationListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/10 19:41
 * @since 1.0.0
 */
@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = {
        "com.prosayj",
})
public class ProsayjAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    public ModuleInitApplicationListener moduleInitApplicationListener() {
        new ModuleInitApplicationListener();
        return new ModuleInitApplicationListener();
    }
}
