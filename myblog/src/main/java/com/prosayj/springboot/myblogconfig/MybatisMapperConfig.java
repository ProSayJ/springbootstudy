package com.prosayj.springboot.myblogconfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

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
