package com.prosayj.springboot.config;

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
        "com.prosayj.springboot.blog_t.models.article.mapper",
        "com.prosayj.springboot.blog_t.models.image.mapper"
})
public class MybatisMapperConfig {
}
