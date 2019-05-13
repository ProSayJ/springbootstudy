package com.prosayj.springboot.blog.manager.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.core.entity.article.dto.ArticleDto;

import java.util.Map;

public interface ArticleService extends IService<Article> {

    /**
     * 分页查询博文列表
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存博文文章
     *
     * @param blogArticle
     */
    void saveArticle(ArticleDto blogArticle);

    /**
     * 批量删除
     *
     * @param articleIds
     */
    void deleteBatch(Integer[] articleIds);

    /**
     * 更新博文
     *
     * @param blogArticle
     */
    void updateArticle(ArticleDto blogArticle);

    /**
     * 获取文章对象
     *
     * @param articleId
     * @return
     */
    ArticleDto getArticle(Integer articleId);


    boolean checkByCategory(Integer id);
}
