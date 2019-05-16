package com.prosayj.springboot.myblog.models.tags.mapper;

import com.prosayj.springboot.myblog.models.tags.domain.TagsDomain;

import java.util.List;

public interface TagsDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagsDomain record);

    int insertSelective(TagsDomain record);

    TagsDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagsDomain record);

    int updateByPrimaryKey(TagsDomain record);

    List<TagsDomain> getTagsByArticelId(Long articleId);
}