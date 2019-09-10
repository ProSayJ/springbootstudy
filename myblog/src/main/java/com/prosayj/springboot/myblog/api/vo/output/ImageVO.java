package com.prosayj.springboot.myblog.api.vo.output;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/7 下午 11:14
 * @since 1.0.0
 */
public class ImageVO {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "文章ID")
    private Long articleId;

    @ApiModelProperty(value = "图片名称")
    private String imgName;

    @ApiModelProperty(value = "图片DB地址")
    private String imgDbUrl;

    @ApiModelProperty(value = "图片静态资源位置")
    private String imgStaticUrl;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;


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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
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

    @Override
    public String toString() {
        return "ImageVO{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", imgName='" + imgName + '\'' +
                ", imgDbUrl='" + imgDbUrl + '\'' +
                ", imgStaticUrl='" + imgStaticUrl + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
