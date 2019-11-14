package com.prosayj.springboot.blog.protal.article.controller;


import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.article.vo.ArticleVo;
import com.prosayj.springboot.blog.protal.article.service.ArticleService;
import com.prosayj.springboot.blog.protal.common.annotation.LogLike;
import com.prosayj.springboot.blog.protal.common.annotation.LogView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yangjian
 * @description
 * @Date 16:00 2019/5/14
 * @since 1.0.0
 */
@Api(value = "ArticleController", tags = "ArticleController", description = "文章-前端控制器")
@RestController("articlePortalController")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "通过id获取文章", nickname = "ArticleController-article/")
    @GetMapping("/article/{articleId}")
    @LogView(type = "article")
    public Result getArticle(@ApiParam(name = "articleId", value = "文章id")
                             @PathVariable Integer articleId) {
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
