package com.prosayj.springboot.blog.models.image.service;

import com.prosayj.springboot.blog.models.image.module.ImageDTO;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/18 17:24
 * @since 1.0.0
 */
public interface ImageService {

    Long save(ImageDTO imageDTO);
}
