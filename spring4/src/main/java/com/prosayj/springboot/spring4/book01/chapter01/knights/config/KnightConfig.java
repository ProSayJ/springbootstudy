package com.prosayj.springboot.spring4.book01.chapter01.knights.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring4.book01.chapter01.knights.BraveKnight;
import spring4.book01.chapter01.knights.Knight;
import spring4.book01.chapter01.knights.Quest;
import spring4.book01.chapter01.knights.SlayDragonQuest;

@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

}
