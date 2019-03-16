package com.prosayj.springboot.blog.api.vo.input;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/13 12:01
 * @since 1.0.0
 */
public class BlogCreateVO {

    @ApiModelProperty(value = "主键", required = false)
    private int id;

    @ApiModelProperty(value = "文章id", required = false)
    private long articleId;

    @ApiModelProperty(value = "文章作者", required = true)
    @NotEmpty
    private String author;

    @ApiModelProperty(value = "文章原作者", required = false)
    private String originalAuthor;

    @ApiModelProperty(value = "文章名称", required = true)
    @NotNull
    private String articleTitle;

    @ApiModelProperty(value = "发布时间", required = false)
    private String publishDate;

    @ApiModelProperty(value = "最后一次修改时间", required = false)
    private String updateDate;

    @ApiModelProperty(value = "文章内容_md", required = false)
    private String articleContent;

    @ApiModelProperty(value = "文章内容_html", required = false)
    private String articleHtmlContent;


    @ApiModelProperty(value = "文章标签", required = false)
    private String articleTags;

    @ApiModelProperty(value = "文章类型", required = false)
    private String articleType;

    @ApiModelProperty(value = "博客分类", required = true)
    @NotEmpty
    private String articleCategories;


    /**
     * 原文链接
     * 转载：则是转载的链接
     * 原创：则是在本博客中的链接
     */
    @ApiModelProperty(value = "原文链接", required = false)
    private String articleUrl;

    @ApiModelProperty(value = "文章摘要", required = false)
    private String articleTabloid;

    @ApiModelProperty(value = "上一篇文章id", required = false)
    private long lastArticleId;

    @ApiModelProperty(value = "下一篇文章id", required = false)
    private long nextArticleId;

    @ApiModelProperty(value = "喜欢", required = false)
    private int likes = 0;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleHtmlContent() {
        return articleHtmlContent;
    }

    public void setArticleHtmlContent(String articleHtmlContent) {
        this.articleHtmlContent = articleHtmlContent;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
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

    public String getArticleTabloid() {
        return articleTabloid;
    }

    public void setArticleTabloid(String articleTabloid) {
        this.articleTabloid = articleTabloid;
    }

    public long getLastArticleId() {
        return lastArticleId;
    }

    public void setLastArticleId(long lastArticleId) {
        this.lastArticleId = lastArticleId;
    }

    public long getNextArticleId() {
        return nextArticleId;
    }

    public void setNextArticleId(long nextArticleId) {
        this.nextArticleId = nextArticleId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "BlogCreateVO{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", author='" + author + '\'' +
                ", originalAuthor='" + originalAuthor + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleHtmlContent='" + articleHtmlContent + '\'' +
                ", articleTags='" + articleTags + '\'' +
                ", articleType='" + articleType + '\'' +
                ", articleCategories='" + articleCategories + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", articleTabloid='" + articleTabloid + '\'' +
                ", lastArticleId=" + lastArticleId +
                ", nextArticleId=" + nextArticleId +
                ", likes=" + likes +
                '}';
    }
}
