package com.prosayj.springboot.models.bizarticlelook.mapper;

import com.prosayj.springboot.models.bizarticlelook.domain.BizArticleLookDomain;

public interface BizArticleLookDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizArticleLookDomain record);

    int insertSelective(BizArticleLookDomain record);

    BizArticleLookDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizArticleLookDomain record);

    int updateByPrimaryKey(BizArticleLookDomain record);
}