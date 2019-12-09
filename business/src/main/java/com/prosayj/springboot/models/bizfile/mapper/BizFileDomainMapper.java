package com.prosayj.springboot.models.bizfile.mapper;

import com.prosayj.springboot.models.bizfile.domain.BizFileDomain;

public interface BizFileDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BizFileDomain record);

    int insertSelective(BizFileDomain record);

    BizFileDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizFileDomain record);

    int updateByPrimaryKey(BizFileDomain record);
}