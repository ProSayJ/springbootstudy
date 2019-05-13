package com.prosayj.springboot.blog.manager.article.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.constants.RedisKeyConstants;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.common.mq.annotation.RefreshEsMqSender;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.validator.ValidatorUtils;
import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.core.entity.article.dto.ArticleDto;
import com.prosayj.springboot.blog.manager.article.service.ArticleService;
import com.prosayj.springboot.blog.manager.operation.service.RecommendService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("/admin/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private RecommendService recommendService;

    @GetMapping("/list")
    @RequiresPermissions("article:list")
    public Result listArticle(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);
        return Result.ok().put("page", page);
    }

    @GetMapping("/info/{articleId}")
    @RequiresPermissions("article:list")
    public Result info(@PathVariable Integer articleId) {
        ArticleDto article = articleService.getArticle(articleId);
        return Result.ok().put("article", article);
    }

    @PostMapping("/save")
    @RequiresPermissions("article:save")
    @RefreshEsMqSender
    public Result saveArticle(@RequestBody ArticleDto article) {
        ValidatorUtils.validateEntity(article);
        articleService.saveArticle(article);
        return Result.ok();
    }

    @PutMapping("/update")
    @RequiresPermissions("article:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    @RefreshEsMqSender
    public Result updateArticle(@RequestBody ArticleDto article) {
        ValidatorUtils.validateEntity(article);
        article.setUpdateTime(new Date());
        articleService.updateArticle(article);
        return Result.ok();
    }

    @PutMapping("/update/status")
    @RequiresPermissions("article:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    @RefreshEsMqSender
    public Result updateStatus(@RequestBody Article article) {
        articleService.updateById(article);
        return Result.ok();
    }


    @DeleteMapping("/delete")
    @RequiresPermissions("article:delete")
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    @RefreshEsMqSender
    public Result deleteBatch(@RequestBody Integer[] articleIds) {
        recommendService.deleteBatchByLinkId(articleIds, ModuleEnum.ARTICLE.getValue());
        articleService.deleteBatch(articleIds);
        return Result.ok();
    }

}
