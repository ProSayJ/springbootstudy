package com.prosayj.springboot.blog.api;

import com.prosayj.springboot.blog.api.vo.output.ArticleVO;
import com.prosayj.springboot.blog.models.article.ArticleService;
import com.prosayj.springboot.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
    @Autowired
    private ArticleService articleService;


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

    @ApiOperation(value = "文章预览列表页", nickname = "static-jump-controller-articlelist")
    @GetMapping("/articlelist")
    public String articlelist(Model model) {
        model.addAttribute("title", "用户列表");
        model.addAttribute("hello","Hello, Spring Boot!");


        List<ArticleVO> articleVOS = BeanUtil.toBeanList(articleService.query(), ArticleVO.class);
        model.addAttribute("articleList",articleVOS);
        return "articlelist";
//        return "example";
    }

    @ApiOperation(value = "文章回显编辑", nickname = "static-jump-controller-echo")
    @GetMapping("/example")
    public String example() {
        return "example";
    }
}
