package com.prosayj.springboot.models.biztags.mapper;

import com.prosayj.springboot.models.biztags.domain.BizTagsDomain;

public interface BizTagsDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizTagsDomain record);

    int insertSelective(BizTagsDomain record);

    BizTagsDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizTagsDomain record);

    int updateByPrimaryKey(BizTagsDomain record);
}