package com.prosayj.springboot.models.biztype.mapper;

import com.prosayj.springboot.models.biztype.domain.BizTypeDomain;

public interface BizTypeDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizTypeDomain record);

    int insertSelective(BizTypeDomain record);

    BizTypeDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizTypeDomain record);

    int updateByPrimaryKey(BizTypeDomain record);
}