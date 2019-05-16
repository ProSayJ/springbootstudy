package com.prosayj.springboot.myblog.models.service;


import com.prosayj.springboot.myblog.models.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {

    void insert(ArticleDTO articleDTO);

    ArticleDTO getArticelByPrimaryKey(Long id);

    List<ArticleDTO> query();

    List<ArticleDTO> queryByTags(Long tags);

    void updateByCondition(ArticleDTO articleDTO);

}
