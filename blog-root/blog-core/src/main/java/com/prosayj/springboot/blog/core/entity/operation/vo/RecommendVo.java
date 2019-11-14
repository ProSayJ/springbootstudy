package com.prosayj.springboot.blog.core.entity.operation.vo;

import com.prosayj.springboot.blog.core.entity.operation.Recommend;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * RecommendVo
 */
@Data
public class RecommendVo extends Recommend {

    private String description;

    private Long readNum;

    private Long commentNum;

    private Long likeNum;

    private String urlType;

    private String cover;

    private Date createTime;

    private List<Tag> tagList;

}
