package com.prosayj.springboot.models.sysrole.mapper;

import com.prosayj.springboot.models.sysrole.domain.SysRoleDomain;

public interface SysRoleDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDomain record);

    int insertSelective(SysRoleDomain record);

    SysRoleDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDomain record);

    int updateByPrimaryKey(SysRoleDomain record);
}