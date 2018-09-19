package com.prosayj.models.user.mapper;

import com.prosayj.models.user.domain.UserDomain;

import java.util.List;

public interface UserDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    UserDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);

    List<UserDomain> queryByCondition(UserDomain userDomain);
}