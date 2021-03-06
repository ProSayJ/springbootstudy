package com.prosayj.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yangjian
 * @description
 * @Date 下午 11:27 2019/11/3
 * @since 1.0.0
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RestController
@EnableSwagger2
public class SecurityDemoApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello spring security";
    }

}
