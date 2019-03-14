package com.prosayj.springboot.blog.api;

import com.prosayj.springboot.blog.models.article.ArticleService;
import com.prosayj.springboot.blog.models.article.module.ArticleDTO;
import com.prosayj.springboot.blog.api.vo.input.BlogCreateVO;
import com.prosayj.springboot.blog.api.vo.input.IdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description 文章控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/12 10:57
 * @since 1.0.0
 */
@Api(value = "article-controller", tags = "article-controller", description = "文章操作类")
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @ApiOperation(value = "发布文章", nickname = "article-publish-article")
    @PostMapping("/publish-article")
    @ResponseBody
    public Map<String, String> publishArticle(BlogCreateVO blogs) {
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

    @ApiOperation(value = "文章内容回显", nickname = "article-echo")
    @PostMapping("/echo")
    @ResponseBody
    public String articleEcho(IdVO idVO) {
        String articleMdContent = articleService.getArticelByPrimaryKey(1L).getArticleMdContent();
        return articleMdContent;
    }

}
