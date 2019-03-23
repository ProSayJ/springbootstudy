package com.prosayj.springboot.models.systemplate.mapper;

import com.prosayj.springboot.models.systemplate.domain.SysTemplateDomain;

public interface SysTemplateDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysTemplateDomain record);

    int insertSelective(SysTemplateDomain record);

    SysTemplateDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysTemplateDomain record);

    int updateByPrimaryKeyWithBLOBs(SysTemplateDomain record);

    int updateByPrimaryKey(SysTemplateDomain record);
}