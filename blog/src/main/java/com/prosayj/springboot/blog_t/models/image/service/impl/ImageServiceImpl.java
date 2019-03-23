package com.prosayj.springboot.blog_t.models.image.service.impl;

import com.prosayj.springboot.blog_t.models.image.domain.ImageDomain;
import com.prosayj.springboot.blog_t.models.image.mapper.ImageDomainMapper;
import com.prosayj.springboot.blog_t.models.image.module.ImageDTO;
import com.prosayj.springboot.blog_t.models.image.service.ImageService;
import com.prosayj.springboot.constants.Constants;
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
    public String save(ImageDTO imageDTO) {
        ImageDomain imageDomain = new ImageDomain();
        imageDomain.setUserId(Constants.NO_ID);
        imageDomain.setArticleId(imageDTO.getArticleId());
        imageDomain.setImgDbUrl(Constants.ENPTY_STRING);
        imageDomain.setImgStaticUrl(imageDTO.getImgStaticUrl());
        imageDomain.setCreateDate(new Date());
        imageDomain.setUpdateDate(new Date());
        imageDomain.setIsDelete((byte) 2);
        imageDomain.setImgSource(imageDTO.getImgSource());
        imageDomain.setImgName(imageDTO.getImgName());
        imageDomain.setImgSuffix(imageDTO.getImgSuffix());
        imageDomainMapper.insert(imageDomain);
        Long imageDomainId = imageDomain.getId();

        //更新dburl
        ImageDomain updateDomain = new ImageDomain();
        updateDomain.setId(imageDomainId);
        updateDomain.setImgDbUrl("\\file\\img-download?id=" + imageDomainId);
        updateDomain.setUpdateDate(new Date());
        imageDomainMapper.updateByPrimaryKeySelective(updateDomain);
        return updateDomain.getImgDbUrl();
    }
}
