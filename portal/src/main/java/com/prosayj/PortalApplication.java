package com.prosayj;

import com.prosayj.springboot.BussinessConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * 排除数据库依赖：
 * DataSourceAutoConfiguration.class,
 * DataSourceTransactionManagerAutoConfiguration.class,
 * HibernateJpaAutoConfiguration.class,
 * DruidDataSourceAutoConfigure.class,
 * <p>
 * 关闭安全验证：
 * SecurityAutoConfiguration
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@MapperScan(basePackageClasses = BussinessConfig.class)
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }

}
