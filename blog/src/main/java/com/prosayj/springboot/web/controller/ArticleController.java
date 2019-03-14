package com.prosayj.springboot.web.controller;

import com.prosayj.springboot.models.article.ArticleService;
import com.prosayj.springboot.models.article.module.ArticleDTO;
import com.prosayj.springboot.web.controller.vo.Blogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description 文章控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/12 10:57
 * @since 1.0.0
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/editor")
    public String login() {
        return "editor";
    }

    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }

    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @PostMapping("/publishArticle")
    @ResponseBody
    public Map<String, String> publishArticle(Blogs blogs, HttpServletRequest request) {
        String mdArticleContent = blogs.getArticleContent();
        System.out.println(mdArticleContent);
        //获得文章html代码并生成摘要
        String articleHtmlContent = blogs.getArticleHtmlContent();
        System.out.println(articleHtmlContent);
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleMdContent(blogs.getArticleContent());
        articleDTO.setArticleHtmlContent(blogs.getArticleHtmlContent());
        articleService.insert(articleDTO);
        return result;
    }

    @PostMapping("/article/echo")
    @ResponseBody
    public String articleEcho(Blogs blogs, HttpServletRequest request) {
        String articleMdContent = articleService.getArticelByPrimaryKey(1L).getArticleMdContent();
        return articleMdContent;
    }

}
