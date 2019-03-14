package com.prosayj.springboot.editdemo.controller;

import com.prosayj.springboot.editdemo.controller.constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangjian
 * @description 文章控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/12 10:57
 * @since 1.0.0
 */
@Controller
public class ReadMeController {
    @GetMapping("/")
    public String redirect() {
        return "redirect:/index";
    }


    @GetMapping("/index")
    public String login() {
        return "example/index";
    }

    @GetMapping("/simple.html")
    public String simple() {
        return "example/simple";
    }

    @GetMapping("/full.html")
    public String full() {
        return "example/full";
    }

    @GetMapping("/emoji.html")
    public String emoji() {
        return "example/emoji";
    }

    @GetMapping("/test.md")
    @ResponseBody
    public String testMd() {
//        return Constant.mdSrc_1;
        return Constant.mdSrc;
    }

    @GetMapping("/use-requirejs.html")
    public String useRequirejs() {
        return "example/use-requirejs";
    }

}
