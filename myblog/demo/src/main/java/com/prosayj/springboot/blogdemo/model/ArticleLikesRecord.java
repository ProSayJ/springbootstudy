package com.prosayj.springboot.blogdemo.model;

import lombok.Data;

/**
 * Describe: 文章点赞记录
 */
@Data
public class ArticleLikesRecord {

    private long id;

    /**
     * 文章id
     */
    private long articleId;

    /**
     * 原作者
     */
    private String originalAuthor;

    /**
     * 点赞人
     */
    private int likerId;

    /**
     * 点赞时间
     */
    private String likeDate;

    public ArticleLikesRecord() {
    }

    public ArticleLikesRecord(long articleId, String originalAuthor, int likerId, String likeDate) {
        this.articleId = articleId;
        this.originalAuthor = originalAuthor;
        this.likerId = likerId;
        this.likeDate = likeDate;
    }
}
