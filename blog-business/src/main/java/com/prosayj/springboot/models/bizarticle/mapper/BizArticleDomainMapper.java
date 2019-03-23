package com.prosayj.springboot.models.bizarticle.mapper;

import com.prosayj.springboot.models.bizarticle.domain.BizArticleDomain;

public interface BizArticleDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizArticleDomain record);

    int insertSelective(BizArticleDomain record);

    BizArticleDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizArticleDomain record);

    int updateByPrimaryKeyWithBLOBs(BizArticleDomain record);

    int updateByPrimaryKey(BizArticleDomain record);
}