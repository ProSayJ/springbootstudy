package com.prosayj.springboot.blog.protal.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.constants.RedisKeyConstants;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import com.prosayj.springboot.blog.core.entity.operation.vo.TagVo;
import com.prosayj.springboot.blog.core.mapper.operation.TagMapper;
import com.prosayj.springboot.blog.protal.operation.service.TagService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TagPortalService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


    /**
     * 获取tagVoList
     *
     * @return
     */
    @Override
    @Cacheable(value = RedisKeyConstants.PORTAL_TAG_LIST)
    public List<TagVo> listTagVo() {
        return baseMapper.listTagVo();
    }
}
