package com.prosayj.springboot.blog.models.image.service.impl;

import com.prosayj.springboot.blog.models.image.domain.ImageDomain;
import com.prosayj.springboot.blog.models.image.mapper.ImageDomainMapper;
import com.prosayj.springboot.blog.models.image.module.ImageDTO;
import com.prosayj.springboot.blog.models.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/18 17:25
 * @since 1.0.0
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDomainMapper imageDomainMapper;

    @Override
    public Long save(ImageDTO imageDTO) {
        ImageDomain imageDomain = new ImageDomain();
        imageDomain.setUserId(99L);
        imageDomain.setArticleId(99L);
        imageDomain.setImgUrl("www.baudi.com");
        imageDomain.setCreateDate(new Date());
        imageDomain.setUpdateDate(new Date());
        imageDomain.setIsDelete((byte) 2);
        imageDomain.setImgSource(imageDTO.getImgSource());
        imageDomainMapper.insert(imageDomain);
        return imageDomain.getId();
    }
}
