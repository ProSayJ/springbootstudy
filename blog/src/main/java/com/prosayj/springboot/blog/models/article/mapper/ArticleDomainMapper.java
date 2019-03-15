package com.prosayj.springboot.blog.models.article.mapper;

import com.prosayj.springboot.blog.models.article.domain.ArticleDomain;

import java.util.List;

public interface ArticleDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleDomain record);

    int insertSelective(ArticleDomain record);

    ArticleDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleDomain record);

    int updateByPrimaryKeyWithBLOBs(ArticleDomain record);

    int updateByPrimaryKey(ArticleDomain record);

    List<ArticleDomain> selectByCondition();
}