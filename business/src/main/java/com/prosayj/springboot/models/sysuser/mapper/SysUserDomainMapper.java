package com.prosayj.springboot.models.sysuser.mapper;

import com.prosayj.springboot.models.sysuser.domain.SysUserDomain;

public interface SysUserDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserDomain record);

    int insertSelective(SysUserDomain record);

    SysUserDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserDomain record);

    int updateByPrimaryKey(SysUserDomain record);
}