package com.prosayj.springboot.blog.protal.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import com.prosayj.springboot.blog.core.entity.operation.vo.TagVo;

import java.util.List;

/**
 * TagService
 */
public interface TagService extends IService<Tag> {

    /**
     * 获取tagVoList
     *
     * @return
     */
    List<TagVo> listTagVo();
}
