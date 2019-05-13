package com.prosayj.springboot.myblog.models.article.service;

import com.prosayj.springboot.blog_t.models.article.module.ArticleDTO;

import java.util.List;

public interface ArticleService {

    void insert(ArticleDTO articleDTO);

    ArticleDTO getArticelByPrimaryKey(Long id);

    List<ArticleDTO> query();

    void updateByCondition(ArticleDTO articleDTO);

}
