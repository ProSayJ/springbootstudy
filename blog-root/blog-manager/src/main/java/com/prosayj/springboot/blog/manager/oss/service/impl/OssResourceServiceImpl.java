package com.prosayj.springboot.blog.manager.oss.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.entity.oss.OssResource;
import com.prosayj.springboot.blog.core.mapper.oss.OssResourceMapper;
import com.prosayj.springboot.blog.manager.oss.service.OssResourceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 云存储资源表 服务实现类
 * </p>
 *
 */
@Service
public class OssResourceServiceImpl extends ServiceImpl<OssResourceMapper, OssResource> implements OssResourceService {

}
