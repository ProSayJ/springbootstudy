package com.prosayj.springboot.spring5._01_circulardependencines;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:com/prosayj/springboot/spring5/_01_circulardependencines/beans.xml")
@ComponentScan("com.prosayj.springboot.spring5._01_circulardependencines")
public class MainConfig {

    //@Bean
    public InstanceA registInstancA() {
        return new InstanceA();
    }

    //@Bean
    public InstanceB registInstanB() {
        return new InstanceB();
    }
}
