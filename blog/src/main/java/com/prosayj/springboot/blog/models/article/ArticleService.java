package com.prosayj.springboot.blog.models.article;

import com.prosayj.springboot.blog.models.article.module.ArticleDTO;

import java.util.List;

public interface ArticleService {

    void insert(ArticleDTO articleDTO);

    ArticleDTO getArticelByPrimaryKey(Long id);

    List<ArticleDTO> query();


}
