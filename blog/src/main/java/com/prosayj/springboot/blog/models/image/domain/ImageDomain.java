package com.prosayj.springboot.blog.models.image.domain;

import java.util.Date;

public class ImageDomain {
    private Long id;

    private Long userId;

    private Long articleId;

    private String imgUrl;

    private Date createDate;

    private Date updateDate;

    private Byte isDelete;

    private byte[] imgSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public byte[] getImgSource() {
        return imgSource;
    }

    public void setImgSource(byte[] imgSource) {
        this.imgSource = imgSource;
    }
}