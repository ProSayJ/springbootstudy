package com.prosayj.springboot.blog.manager.operation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.operation.Recommend;
import com.prosayj.springboot.blog.core.entity.operation.vo.RecommendVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 推荐 Mapper 接口
 * </p>
 */
@Mapper
public interface RecommendMapper extends BaseMapper<Recommend> {

    /**
     * 获取推荐文章列表
     *
     * @return
     */
    List<RecommendVo> listSelect();

    /**
     * 获取推荐列表
     *
     * @return
     */
    List<RecommendVo> listRecommendVo();

    /**
     * 获取最热列表
     *
     * @return
     */
    List<RecommendVo> listHotRead();
}
