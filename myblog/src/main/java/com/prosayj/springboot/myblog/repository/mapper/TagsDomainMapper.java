package com.prosayj.springboot.myblog.repository.mapper;

import com.prosayj.springboot.myblog.repository.domain.TagsDomain;

import java.util.List;

public interface TagsDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagsDomain record);

    int insertSelective(TagsDomain record);

    TagsDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagsDomain record);

    int updateByPrimaryKey(TagsDomain record);

    List<TagsDomain> getTagsByArticelId(Long articleId);


    List<TagsDomain> getAll();
}