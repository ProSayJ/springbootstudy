package com.prosayj.springboot.myblog.models.articletags.mapper;

import com.prosayj.springboot.myblog.models.articletags.domain.ArticleTagsDomain;

public interface ArticleTagsDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleTagsDomain record);

    int insertSelective(ArticleTagsDomain record);

    ArticleTagsDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleTagsDomain record);

    int updateByPrimaryKey(ArticleTagsDomain record);
}