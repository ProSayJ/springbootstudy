package com.prosayj.springboot.myblog.models.dto;

/**
 * @author yangjian
 * @description
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/16 17:19
 * @since 1.0.0
 */
public class TagsDTO {
    private Integer id;

    private String tagName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
