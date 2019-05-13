package com.prosayj.springboot.blog.protal.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.entity.operation.Recommend;
import com.prosayj.springboot.blog.core.entity.operation.vo.RecommendVo;

import java.util.List;

public interface RecommendService extends IService<Recommend> {

    List<RecommendVo> listRecommendVo();

    List<RecommendVo> listHotRead();
}
