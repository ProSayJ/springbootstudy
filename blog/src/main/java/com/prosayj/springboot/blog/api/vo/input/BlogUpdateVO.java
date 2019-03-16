package com.prosayj.springboot.blog.api.vo.input;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/13 12:01
 * @since 1.0.0
 */
public class BlogUpdateVO {


    @ApiModelProperty(value = "主键", required = false)
    private long id;

    @ApiModelProperty(value = "文章id", required = false)
    private long articleId;


    @ApiModelProperty(value = "文章内容_md", required = false)
    private String articleContent;

    @ApiModelProperty(value = "文章内容_html", required = false)
    private String articleHtmlContent;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
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

    @Override
    public String toString() {
        return "BlogUpdateVO{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", articleContent='" + articleContent + '\'' +
                ", articleHtmlContent='" + articleHtmlContent + '\'' +
                '}';
    }
}
