package com.prosayj.springboot.blog.search.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.constants.RabbitMqConstants;
import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.protal.article.service.ArticleService;
import com.prosayj.springboot.blog.search.mapper.ArticleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangjian
 * @description
 * @Date 16:00 2019/5/14
 * @since 1.0.0
 */
@Api(value = "ArticleEsController", tags = "ArticleEsController", description = "文章关键字搜索控制器")
@RestController
@Slf4j
public class ArticleEsController {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private ArticleService articleService;


    /**
     * 搜索标题，描述，内容
     *
     * @param keywords
     * @return
     */
    @ApiOperation(value = "搜索标题，描述，内容", nickname = "articleesController-articles/search")
    @GetMapping("articles/search")
    public Result search(
            @ApiParam(name = "keywords", value = "搜索关键词（标题、描述、内容）") @RequestParam("keywords") String keywords) {
        // 对所有索引进行搜索
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(keywords);

        Iterable<Article> listIt = articleRepository.search(queryBuilder);

        //Iterable转list
        List<Article> articleList = Lists.newArrayList(listIt);

        return Result.ok().put("articleList", articleList);
    }

    @RabbitListener(queues = RabbitMqConstants.REFRESH_ES_INDEX_QUEUE)
    public void refresh(String msg) {
        articleRepository.deleteAll();
        List<Article> list = articleService.list(new QueryWrapper<Article>().lambda().eq(Article::getPublish, true));
        articleRepository.saveAll(list);
        log.info(msg);
    }

}
