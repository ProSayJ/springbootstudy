package com.prosayj.springboot.models.sysroleresources.mapper;

import com.prosayj.springboot.models.sysroleresources.domain.SysRoleResourcesDomain;

public interface SysRoleResourcesDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleResourcesDomain record);

    int insertSelective(SysRoleResourcesDomain record);

    SysRoleResourcesDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleResourcesDomain record);

    int updateByPrimaryKey(SysRoleResourcesDomain record);
}