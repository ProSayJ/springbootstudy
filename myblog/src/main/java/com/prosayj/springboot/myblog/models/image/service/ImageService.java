package com.prosayj.springboot.blog_t.models.image.service;

import com.prosayj.springboot.blog_t.models.image.domain.ImageDomain;
import com.prosayj.springboot.blog_t.models.image.module.ImageDTO;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/18 17:24
 * @since 1.0.0
 */
public interface ImageService {

    /**
     * 保存图片，返回主键id
     *
     * @param imageDTO
     * @return
     */
    String save(ImageDTO imageDTO);
}
