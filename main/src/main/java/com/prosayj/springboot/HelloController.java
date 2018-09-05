package com.prosayj.springboot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjian
 * @description 第一个测试类
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/5 16:20
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello,this is a springboot demo";
    }
}