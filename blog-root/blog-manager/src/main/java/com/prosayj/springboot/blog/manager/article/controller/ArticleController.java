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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

/**
 * @author yangjian
 * @description 文章控制器
 * @Date 16:57 2019/5/14
 * @since 1.0.0
 */
@Api(value = "ArticleController", tags = "ArticleController", description = "文章控制器")
@RestController
@RequestMapping("/admin/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private RecommendService recommendService;

    @ApiOperation(value = "获取文章列表", nickname = "ArticleController-listArticle")
    @GetMapping("/list")
    @RequiresPermissions("article:list")
    public Result listArticle(
            @ApiParam(name = "params", value = "查询条件", required = true)
            @RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);
        return Result.ok().put("page", page);
    }

    @ApiOperation(value = "获取文章的基本信息-标签", nickname = "ArticleController-info")
    @GetMapping("/info/{articleId}")
    @RequiresPermissions("article:list")
    public Result info(
            @ApiParam(name = "articleId", value = "文章id", required = true)
            @Valid @NotNull @NotEmpty @PathVariable("articleId") Integer articleId) {
        ArticleDto article = articleService.getArticle(articleId);
        return Result.ok().put("article", article);
    }

    @ApiOperation(value = "保存文章", nickname = "ArticleController-save")
    @PostMapping("/save")
    @RequiresPermissions("article:save")
    @RefreshEsMqSender
    public Result saveArticle(@RequestBody ArticleDto article) {
        ValidatorUtils.validateEntity(article);
        articleService.saveArticle(article);
        return Result.ok();
    }

    @ApiOperation(value = "更新文章", nickname = "ArticleController-update")
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

    @ApiOperation(value = "更新文章状态", nickname = "ArticleController-update-status")
    @PutMapping("/update/status")
    @RequiresPermissions("article:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    @RefreshEsMqSender
    public Result updateStatus(@RequestBody Article article) {
        articleService.updateById(article);
        return Result.ok();
    }

    @ApiOperation(value = "批量删除文章", nickname = "ArticleController-delete")
    @DeleteMapping("/delete")
    @RequiresPermissions("article:delete")
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    @RefreshEsMqSender
    public Result deleteBatch(@ApiParam(name = "articleIds", value = "文章ids", required = true)
                                  @RequestBody Integer[] articleIds) {
        recommendService.deleteBatchByLinkId(articleIds, ModuleEnum.ARTICLE.getValue());
        articleService.deleteBatch(articleIds);
        return Result.ok();
    }

}
