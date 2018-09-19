package com.prosayj.models.user.mapper;

import com.prosayj.models.user.domain.UserDomain;

public interface UserDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    UserDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);
}