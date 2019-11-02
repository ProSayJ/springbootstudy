package com.prosayj.springboot.myblog.repository.mapper;


import com.prosayj.springboot.myblog.repository.domain.ImageDomain;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ImageDomain record);

    int insertSelective(ImageDomain record);

    ImageDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImageDomain record);

    int updateByPrimaryKeyWithBLOBs(ImageDomain record);

    int updateByPrimaryKey(ImageDomain record);

    List<ImageDomain> getAllImage();

    List<ImageDomain> getByArticleId(Long articleId);
}