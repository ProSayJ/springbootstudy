package com.prosayj.springboot.blog.api;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/11 13:28
 * @since 1.0.0
 */
@Api(value = "hello-controller", tags = "hello-controller", description = "测试类")
@Controller
//@RestController
public class HelloController {

    @GetMapping("/hello")
    public String login() {
        return "hello";
    }

}
