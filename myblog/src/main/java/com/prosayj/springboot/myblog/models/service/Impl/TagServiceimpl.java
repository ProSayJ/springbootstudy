package com.prosayj.springboot.myblog.models.service.Impl;

import com.prosayj.springboot.myblog.models.dto.Convertor;
import com.prosayj.springboot.myblog.models.dto.TagsDTO;
import com.prosayj.springboot.myblog.models.service.TagService;
import com.prosayj.springboot.myblog.models.tags.domain.TagsDomain;
import com.prosayj.springboot.myblog.models.tags.mapper.TagsDomainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/16 17:20
 * @since 1.0.0
 */
@Service
public class TagServiceimpl implements TagService {
    @Autowired
    TagsDomainMapper tagsMapper;

    @Override
    public List<TagsDTO> getAllTags() {
        List<TagsDomain> tagsByArticelId = tagsMapper.getTagsByArticelId(null);

        return Convertor.toTagsDtos(tagsByArticelId);
    }
}
