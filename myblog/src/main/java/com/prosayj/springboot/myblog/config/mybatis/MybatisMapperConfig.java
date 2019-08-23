package com.prosayj.springboot.myblog.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangjian
 * @description mybatis接口扫描
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/19 15:02
 * @since 1.0.0
 */
@Configuration
@MapperScan({
        "com.prosayj.springboot.myblog.repository.mapper"
})
public class MybatisMapperConfig {
}
