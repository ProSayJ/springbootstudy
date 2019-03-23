package com.prosayj.springboot.models.sysconfig.mapper;

import com.prosayj.springboot.models.sysconfig.domain.SysConfigDomain;

public interface SysConfigDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysConfigDomain record);

    int insertSelective(SysConfigDomain record);

    SysConfigDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysConfigDomain record);

    int updateByPrimaryKeyWithBLOBs(SysConfigDomain record);

    int updateByPrimaryKey(SysConfigDomain record);
}