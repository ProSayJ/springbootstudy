package com.prosayj.springboot.myblog.models.dto;

import java.util.Arrays;
import java.util.Date;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/18 17:24
 * @since 1.0.0
 */
public class ImageDTO {
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

    @Override
    public String toString() {
        return "ImageDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", imgName='" + imgName + '\'' +
                ", imgSuffix='" + imgSuffix + '\'' +
                ", imgDbUrl='" + imgDbUrl + '\'' +
                ", imgStaticUrl='" + imgStaticUrl + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", isDelete=" + isDelete +
                ", imgSource=" + Arrays.toString(imgSource) +
                '}';
    }
}
