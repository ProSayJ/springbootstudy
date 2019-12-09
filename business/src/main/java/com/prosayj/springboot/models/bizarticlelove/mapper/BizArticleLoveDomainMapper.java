package com.prosayj.springboot.models.bizarticlelove.mapper;

import com.prosayj.springboot.models.bizarticlelove.domain.BizArticleLoveDomain;

public interface BizArticleLoveDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizArticleLoveDomain record);

    int insertSelective(BizArticleLoveDomain record);

    BizArticleLoveDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizArticleLoveDomain record);

    int updateByPrimaryKey(BizArticleLoveDomain record);
}