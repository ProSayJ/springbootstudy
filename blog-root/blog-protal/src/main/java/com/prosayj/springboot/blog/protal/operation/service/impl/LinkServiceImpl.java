package com.prosayj.springboot.blog.protal.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.constants.RedisKeyConstants;
import com.prosayj.springboot.blog.core.entity.operation.Link;
import com.prosayj.springboot.blog.core.mapper.operation.LinkMapper;
import com.prosayj.springboot.blog.protal.operation.service.LinkService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LinkService
 */
@Service("linkPortalService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


    /**
     * 获取link列表
     *
     * @return
     */
    @Override
    @Cacheable(value = RedisKeyConstants.PORTAL_LINK_LIST)
    public List<Link> listLink() {
        return baseMapper.selectList(null);
    }
}
