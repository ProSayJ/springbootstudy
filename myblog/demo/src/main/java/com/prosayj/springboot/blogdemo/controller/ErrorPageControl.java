package com.prosayj.springboot.blogdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Describe: 错误页面跳转
 */
@Controller
public class ErrorPageControl {

    @GetMapping("/404")
    public String error404(HttpServletRequest request,
                           Model model){
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "404";
    }

    @GetMapping("/403")
    public String error403(HttpServletRequest request,
                           Model model){
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "403";
    }

}
