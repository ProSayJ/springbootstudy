package com.prosayj.springboot.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/11 13:28
 * @since 1.0.0
 */
@Api(value = "static-jump-controller", tags = "static-jump-controller", description = "静态资源跳转类")
@Controller
public class StaticJumpController {
    @ApiOperation(value = "登陆跳转", nickname = "static-jump-controller")
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }


    @ApiOperation(value = "登陆", nickname = "static-jump-controller-login")
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @ApiOperation(value = "注册", nickname = "static-jump-controller-register")
    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @ApiOperation(value = "编辑文章", nickname = "static-jump-controller-editor")
    @GetMapping("/editor")
    public String editor() {
        return "editor";
    }


    @ApiOperation(value = "文章回显编辑", nickname = "static-jump-controller-echo")
    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }


    @ApiOperation(value = "文章浏览", nickname = "static-jump-controller-preview")
    @GetMapping("/preview")
    public String preview() {
        return "preview";
    }
}
