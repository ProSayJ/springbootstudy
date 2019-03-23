package com.prosayj.springboot.models.sysuserrole.mapper;

import com.prosayj.springboot.models.sysuserrole.domain.SysUserRoleDomain;

public interface SysUserRoleDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRoleDomain record);

    int insertSelective(SysUserRoleDomain record);

    SysUserRoleDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRoleDomain record);

    int updateByPrimaryKey(SysUserRoleDomain record);
}