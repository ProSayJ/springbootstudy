package com.prosayj.springboot.blog.manager.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.book.dto.BookDto;

import java.util.Map;

/**
 * <p>
 * 图书表 服务类
 * </p>
 *
 */
public interface BookService extends IService<Book> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存图书
     *
     * @param book
     */
    void saveBook(BookDto book);

    /**
     * 获取图书对象
     *
     * @param id
     * @return
     */
    BookDto getBook(String id);

    /**
     * 更新图书
     *
     * @param book
     */
    void updateBook(BookDto book);

    /**
     * 批量删除
     *
     * @param bookIds
     */
    void deleteBatch(Integer[] bookIds);

    /**
     * @param categoryId
     * @return
     */
    boolean checkByCategory(Integer categoryId);
}
