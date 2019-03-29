package com.prosayj.springboot.models.sysresources.mapper;

import com.prosayj.springboot.models.sysresources.domain.SysResourcesDomain;

public interface SysResourcesDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysResourcesDomain record);

    int insertSelective(SysResourcesDomain record);

    SysResourcesDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResourcesDomain record);

    int updateByPrimaryKey(SysResourcesDomain record);
}