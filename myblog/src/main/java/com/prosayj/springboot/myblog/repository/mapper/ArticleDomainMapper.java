package com.prosayj.springboot.myblog.repository.mapper;


import com.prosayj.springboot.myblog.repository.domain.ArticleDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleDomain record);

    int insertSelective(ArticleDomain record);

    ArticleDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleDomain record);

    int updateByPrimaryKeyWithBLOBs(ArticleDomain record);

    int updateByPrimaryKey(ArticleDomain record);

    List<ArticleDomain> selectByCondition(ArticleDomain record);

}