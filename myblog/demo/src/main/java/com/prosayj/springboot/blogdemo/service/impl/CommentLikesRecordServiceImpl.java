package com.prosayj.springboot.blogdemo.service.impl;

import com.prosayj.springboot.blogdemo.mapper.CommentLikesMapper;
import com.prosayj.springboot.blogdemo.model.CommentLikesRecord;
import com.prosayj.springboot.blogdemo.service.CommentLikesRecordService;
import com.prosayj.springboot.blogdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Describe:
 */
@Service
public class CommentLikesRecordServiceImpl implements CommentLikesRecordService {

    @Autowired
    CommentLikesMapper commentLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, String originalAuthor, long pId, String username) {
        return commentLikesMapper.isLiked(articleId, originalAuthor, pId, userService.findIdByUsername(username)) != null;
    }

    @Override
    public void insertCommentLikesRecord(CommentLikesRecord commentLikesRecord) {
        commentLikesMapper.insertCommentLikesRecord(commentLikesRecord);
    }

    @Override
    public void deleteCommentLikesRecordByArticleId(long articleId) {
        commentLikesMapper.deleteCommentLikesRecordByArticleId(articleId);
    }
}
