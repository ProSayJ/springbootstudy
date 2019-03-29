package com.prosayj.springboot.models.syslog.mapper;

import com.prosayj.springboot.models.syslog.domain.SysLogDomain;

public interface SysLogDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLogDomain record);

    int insertSelective(SysLogDomain record);

    SysLogDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLogDomain record);

    int updateByPrimaryKey(SysLogDomain record);
}