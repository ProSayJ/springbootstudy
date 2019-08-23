package com.prosayj.springboot.myblog.service.Impl;

import com.prosayj.springboot.myblog.models.Convertor;
import com.prosayj.springboot.myblog.models.dto.TagsDTO;
import com.prosayj.springboot.myblog.service.TagService;
import com.prosayj.springboot.myblog.repository.domain.TagsDomain;
import com.prosayj.springboot.myblog.repository.mapper.TagsDomainMapper;
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
        return Convertor.toTagsDtos(tagsMapper.getTagsByArticelId(null));
    }
}
