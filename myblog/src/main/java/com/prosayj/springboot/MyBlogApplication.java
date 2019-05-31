package com.prosayj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
      /*  DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class,*/

    //关闭安全认证
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class

})
public class MyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogApplication.class, args);
    }

}
