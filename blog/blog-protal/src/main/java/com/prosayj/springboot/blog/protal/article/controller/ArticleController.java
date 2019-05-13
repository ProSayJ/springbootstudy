package com.prosayj.springboot.blog.protal.article.controller;


import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.article.vo.ArticleVo;
import com.prosayj.springboot.blog.protal.article.service.ArticleService;
import com.prosayj.springboot.blog.protal.common.annotation.LogLike;
import com.prosayj.springboot.blog.protal.common.annotation.LogView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 */
@RestController("articlePortalController")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{articleId}")
    @LogView(type = "article")
    public Result getArticle(@PathVariable Integer articleId) {
        ArticleVo article = articleService.getArticleVo(articleId);
        return Result.ok().put("article", article);
    }

    @PutMapping("/article/like/{id}")
    @LogLike(type = "article")
    public Result likeArticle(@PathVariable Integer id) {
        return Result.ok();
    }

    @GetMapping("/articles")
    public Result listLatest(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPageCondition(params);
        return Result.ok().put("page", page);
    }

}
