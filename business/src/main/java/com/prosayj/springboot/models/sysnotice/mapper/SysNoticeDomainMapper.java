package com.prosayj.springboot.models.sysnotice.mapper;

import com.prosayj.springboot.models.sysnotice.domain.SysNoticeDomain;

public interface SysNoticeDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysNoticeDomain record);

    int insertSelective(SysNoticeDomain record);

    SysNoticeDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysNoticeDomain record);

    int updateByPrimaryKey(SysNoticeDomain record);
}