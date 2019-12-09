package com.prosayj.springboot.models.sysupdaterecorde.mapper;

import com.prosayj.springboot.models.sysupdaterecorde.domain.SysUpdateRecordeDomain;

public interface SysUpdateRecordeDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUpdateRecordeDomain record);

    int insertSelective(SysUpdateRecordeDomain record);

    SysUpdateRecordeDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUpdateRecordeDomain record);

    int updateByPrimaryKey(SysUpdateRecordeDomain record);
}