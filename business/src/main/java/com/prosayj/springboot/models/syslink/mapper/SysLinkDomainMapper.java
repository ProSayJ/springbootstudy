package com.prosayj.springboot.models.syslink.mapper;

import com.prosayj.springboot.models.syslink.domain.SysLinkDomain;

public interface SysLinkDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLinkDomain record);

    int insertSelective(SysLinkDomain record);

    SysLinkDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLinkDomain record);

    int updateByPrimaryKey(SysLinkDomain record);
}