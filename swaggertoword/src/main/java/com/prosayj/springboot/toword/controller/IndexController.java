package com.prosayj.springboot.toword.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:34
 * @since 1.0.0
 */
public class IndexController {
    public IndexController() {
    }

    @RequestMapping({"/"})
    public String index(HttpServletRequest request) {
        return "index";
    }
}
