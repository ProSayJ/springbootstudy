package com;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * （1）@Configuration：表名该类使用基于Java的配置,将此类作为配置类
 * （2）@ComponentScan：启用注解扫描
 * （3）@EnableAutoConfiguration：开启springboot的自动配置功能
 */
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
//继承的目的是为了部署到外部tomcat中
public class StartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartApplication.class);
    }

    public static void main(String[] args) {
        //原启动方式
        //SpringApplication.run(StartApplication.class, args);

        //隐藏banner启动方式
        SpringApplication springApplication = new SpringApplication(StartApplication.class);
        //设置banner的模式为隐藏
        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动springboot应用程序
        springApplication.run(args);


    }

}
