package com.prosayj.springboot.myblog.repository.domain;

import java.util.Date;

public class ImageDomain {
    private Long id;

    private Long userId;

    private Long articleId;

    private String imgName;

    private String imgSuffix;

    private String imgDbUrl;

    private String imgStaticUrl;

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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgSuffix() {
        return imgSuffix;
    }

    public void setImgSuffix(String imgSuffix) {
        this.imgSuffix = imgSuffix;
    }

    public String getImgDbUrl() {
        return imgDbUrl;
    }

    public void setImgDbUrl(String imgDbUrl) {
        this.imgDbUrl = imgDbUrl;
    }

    public String getImgStaticUrl() {
        return imgStaticUrl;
    }

    public void setImgStaticUrl(String imgStaticUrl) {
        this.imgStaticUrl = imgStaticUrl;
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