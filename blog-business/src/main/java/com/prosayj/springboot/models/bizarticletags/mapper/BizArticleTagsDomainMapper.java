package com.prosayj.springboot.models.bizarticletags.mapper;

import com.prosayj.springboot.models.bizarticletags.domain.BizArticleTagsDomain;

public interface BizArticleTagsDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizArticleTagsDomain record);

    int insertSelective(BizArticleTagsDomain record);

    BizArticleTagsDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizArticleTagsDomain record);

    int updateByPrimaryKey(BizArticleTagsDomain record);
}