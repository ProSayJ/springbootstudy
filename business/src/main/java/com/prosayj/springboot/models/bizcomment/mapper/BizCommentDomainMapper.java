package com.prosayj.springboot.models.bizcomment.mapper;

import com.prosayj.springboot.models.bizcomment.domain.BizCommentDomain;

public interface BizCommentDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizCommentDomain record);

    int insertSelective(BizCommentDomain record);

    BizCommentDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizCommentDomain record);

    int updateByPrimaryKey(BizCommentDomain record);
}