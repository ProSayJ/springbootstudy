package com.prosayj.springboot.models.article.mapper;

import com.prosayj.springboot.models.article.domain.ArticleDomain;

public interface ArticleDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleDomain record);

    int insertSelective(ArticleDomain record);

    ArticleDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleDomain record);

    int updateByPrimaryKeyWithBLOBs(ArticleDomain record);

    int updateByPrimaryKey(ArticleDomain record);
}