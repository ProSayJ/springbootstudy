package com.prosayj.springboot.blogdemo.service.impl;

import com.prosayj.springboot.blogdemo.mapper.ArticleLikesMapper;
import com.prosayj.springboot.blogdemo.model.ArticleLikesRecord;
import com.prosayj.springboot.blogdemo.service.ArticleLikesRecordService;
import com.prosayj.springboot.blogdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Describe:
 */
@Service
public class ArticleLikesRecordServiceImpl implements ArticleLikesRecordService {

    @Autowired
    ArticleLikesMapper articleLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, String originalAuthor, String username) {
        ArticleLikesRecord articleLikesRecord = articleLikesMapper.isLiked(articleId, originalAuthor, userService.findIdByUsername(username));

        return articleLikesRecord != null;
    }

    @Override
    public void insertArticleLikesRecord(ArticleLikesRecord articleLikesRecord) {
        articleLikesMapper.insertArticleLikesRecord(articleLikesRecord);
    }

    @Override
    public void deleteArticleLikesRecordByArticleId(long articleId) {
        articleLikesMapper.deleteArticleLikesRecordByArticleId(articleId);
    }

}
