package com.prosayj.springboot.blog.protal.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.entity.operation.Category;

import java.util.List;
import java.util.Map;

/**
 * CategoryService
 *
 */
public interface CategoryService extends IService<Category> {

    /**
     * 获取categoryList
     * @param params
     * @return
     */
    List<Category> listCategory(Map<String, Object> params);
}
