package com.prosayj.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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
//继承的目的是为了部署到外部tomcat中
public class MainApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApplication.class);
    }

    public static void main(String[] args) {
        //原启动方式
        //SpringApplication.run(TestApplication.class, args);

        //隐藏banner启动方式
        SpringApplication springApplication = new SpringApplication(MainApplication.class);
        //设置banner的模式为隐藏
        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动springboot应用程序
        springApplication.run(args);
    }

}
