package com.prosayj.springboot.myblog.models.dto;

import com.prosayj.springboot.myblog.models.tags.domain.TagsDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/16 17:27
 * @since 1.0.0
 */
public class Convertor {
    public static List<TagsDTO> toTagsDtos(List<TagsDomain> tagsByArticelId) {
        List<TagsDTO> tagsDTOS = new ArrayList<>(tagsByArticelId.size());
        tagsByArticelId.forEach(data -> {
            TagsDTO tagsDTO = new TagsDTO();
            tagsDTO.setId(data.getId());
            tagsDTO.setTagName(data.getTagName());
            tagsDTOS.add(tagsDTO);
        });
        return tagsDTOS;
    }

}
