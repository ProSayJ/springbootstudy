package com.prosayj.springboot.blog.protal.book.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.book.vo.BookVo;

import java.util.Map;


/**
 * <p>
 * 图书表 服务类
 * </p>
 */
public interface BookService extends IService<Book> {

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取Book对象
     *
     * @param id
     * @return
     */
    BookVo getBookVo(Integer id);
}
