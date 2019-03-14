package com.prosayj.springboot.editdemo.controller;

import com.prosayj.springboot.editdemo.controller.constant.Constant;
import com.prosayj.springboot.editdemo.controller.vo.Blogs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/13 11:15
 * @since 1.0.0
 */
@Controller
public class EditArticleController {

    @GetMapping("/editor")
    public String login() {
        return "example/editor";
    }


    @PostMapping("/publishArticle")
    @ResponseBody
    public Map<String, String> publishArticle(Blogs blogs, HttpServletRequest request) {
        String mdArticleContent = blogs.getArticleContent();
        System.out.println(mdArticleContent);

        //获得文章html代码并生成摘要
        String articleHtmlContent = blogs.getArticleHtmlContent();
        System.out.println(articleHtmlContent);

//        Constant.mdSrc_1 = mdArticleContent;
        Constant.mdSrc = mdArticleContent;

        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        return result;
    }

    @GetMapping("/test.md")
    @ResponseBody
    public String testMd() {
//        return Constant.mdSrc_1;
        return Constant.mdSrc;
    }


}
