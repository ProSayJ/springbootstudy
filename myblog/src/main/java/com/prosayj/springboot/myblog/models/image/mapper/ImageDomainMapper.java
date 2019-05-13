package com.prosayj.springboot.blog_t.models.image.mapper;

import com.prosayj.springboot.blog_t.models.image.domain.ImageDomain;

import java.util.List;

public interface ImageDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ImageDomain record);

    int insertSelective(ImageDomain record);

    ImageDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImageDomain record);

    int updateByPrimaryKeyWithBLOBs(ImageDomain record);

    int updateByPrimaryKey(ImageDomain record);

    List<ImageDomain> getAllImage();
}