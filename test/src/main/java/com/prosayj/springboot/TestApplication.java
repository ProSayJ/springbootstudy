package com.prosayj.springboot;

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
//@MapperScan(basePackageClasses = BussinessConfig.class)
/*@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.prosayj\\.springboot\\.designmode\\.研磨设计模式\\..*")
})*/
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
