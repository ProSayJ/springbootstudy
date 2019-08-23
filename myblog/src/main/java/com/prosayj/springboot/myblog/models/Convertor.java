package com.prosayj.springboot.myblog.models;

import com.prosayj.springboot.myblog.repository.domain.TagsDomain;
import com.prosayj.springboot.myblog.models.dto.TagsDTO;
import com.prosayj.springboot.utils.BeanUtil;

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
        List<TagsDTO> tagsDTOS = BeanUtil.toBeanList(tagsByArticelId, TagsDTO.class);

//        List<TagsDTO> tagsDTOS = new ArrayList<>(tagsByArticelId.size());
//        tagsByArticelId.forEach(data -> {
//            TagsDTO tagsDTO = new TagsDTO();
//            tagsDTO.setId(data.getId());
//            tagsDTO.setTagName(data.getTagName());
//            tagsDTOS.add(tagsDTO);
//        });
        return tagsDTOS;
    }

}
