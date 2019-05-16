package com.prosayj.springboot.myblog.models.dto;

import java.util.Date;

public class ArticleDTO {

    private Long id;

    private Long articleId;

    private Long authorId;

    private String originalAuthor;

    private String articleTitle;

    private String articleTags;

    private Byte articleType;

    private String articleCategories;

    private String articleUrl;

    private String likes;

    private String lastArticleId;

    private Integer nextArticleId;

    private Date publishDate;

    private Date updateDate;

    private Byte isDelete;

    private String articleSummary;

    private String articleHtmlContent;

    private String articleMdContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getOriginalAuthor() {
        return originalAuthor;
    }

    public void setOriginalAuthor(String originalAuthor) {
        this.originalAuthor = originalAuthor;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags;
    }

    public Byte getArticleType() {
        return articleType;
    }

    public void setArticleType(Byte articleType) {
        this.articleType = articleType;
    }

    public String getArticleCategories() {
        return articleCategories;
    }

    public void setArticleCategories(String articleCategories) {
        this.articleCategories = articleCategories;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getLastArticleId() {
        return lastArticleId;
    }

    public void setLastArticleId(String lastArticleId) {
        this.lastArticleId = lastArticleId;
    }

    public Integer getNextArticleId() {
        return nextArticleId;
    }

    public void setNextArticleId(Integer nextArticleId) {
        this.nextArticleId = nextArticleId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleHtmlContent() {
        return articleHtmlContent;
    }

    public void setArticleHtmlContent(String articleHtmlContent) {
        this.articleHtmlContent = articleHtmlContent;
    }

    public String getArticleMdContent() {
        return articleMdContent;
    }

    public void setArticleMdContent(String articleMdContent) {
        this.articleMdContent = articleMdContent;
    }

}
