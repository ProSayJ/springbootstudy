package com.prosayj.springboot;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangjian
 * @description 第一个测试类
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/5 16:20
 * @since 1.0.0
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/list")
    public @ResponseBody
    String list(Model model) {
        return "hello spring boot~";

    }

}