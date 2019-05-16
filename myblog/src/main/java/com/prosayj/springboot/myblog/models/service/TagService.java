package com.prosayj.springboot.myblog.models.service;

import com.prosayj.springboot.myblog.models.dto.TagsDTO;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/16 17:16
 * @since 1.0.0
 */
public interface TagService {
    List<TagsDTO> getAllTags();
}
