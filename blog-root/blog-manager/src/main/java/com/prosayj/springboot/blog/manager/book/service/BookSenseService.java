package com.prosayj.springboot.blog.manager.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.entity.book.BookSense;

/**
 * <p>
 * 读后感 服务类
 * </p>
 */
public interface BookSenseService extends IService<BookSense> {

    /**
     * 获取读后感
     *
     * @param bookId
     * @return
     */
    BookSense getBookSense(Integer bookId);
}
