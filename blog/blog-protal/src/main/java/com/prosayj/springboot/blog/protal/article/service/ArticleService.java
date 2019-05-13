package com.prosayj.springboot.blog.protal.article.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.core.entity.article.vo.ArticleVo;

import java.util.Map;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页分类获取列表
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取ArticleVo对象
     * @param articleId
     * @return
     */
    ArticleVo getArticleVo(Integer articleId);

    /**
     * 获取简单的Article对象
     * @param articleId
     * @return
     */
     ArticleVo getSimpleArticleVo(Integer articleId);

}
