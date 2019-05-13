package com.prosayj.springboot.blog.protal.operation.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.entity.operation.Category;
import com.prosayj.springboot.blog.protal.operation.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * CategoryController
 */
@RestController("categoryPortalController")
@RequestMapping("/operation")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/categories")
    public Result listCategory(@RequestParam Map<String, Object> params) {
        List<Category> categoryList = categoryService.listCategory(params);
        return Result.ok().put("categoryList", categoryList);
    }

}
