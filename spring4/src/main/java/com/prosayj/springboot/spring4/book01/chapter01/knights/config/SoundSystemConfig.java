package com.prosayj.springboot.spring4.book01.chapter01.knights.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.habuma.soundsystem",
               excludeFilters = { @Filter(Configuration.class) })
public class SoundSystemConfig {
}
