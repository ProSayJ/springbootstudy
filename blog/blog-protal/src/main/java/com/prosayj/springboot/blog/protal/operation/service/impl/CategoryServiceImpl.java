package com.prosayj.springboot.blog.protal.operation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.entity.operation.Category;
import com.prosayj.springboot.blog.core.mapper.operation.CategoryMapper;
import com.prosayj.springboot.blog.protal.operation.service.CategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("categoryPortalService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    /**
     * 获取categoryList
     *
     * @param params
     * @return
     */
    @Override
    public List<Category> listCategory(Map<String, Object> params) {
        String type = (String) params.get("type");
        String rank = (String) params.get("rank");
        return baseMapper.selectList(new QueryWrapper<Category>().lambda()
                .eq(StringUtils.isNotEmpty(type), Category::getType, type)
                .eq(StringUtils.isNotEmpty(rank), Category::getRank, rank));
    }
}
