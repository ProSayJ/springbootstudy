package com.prosayj.springboot.blog.protal.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.core.entity.book.vo.BookNoteVo;

import java.util.List;
import java.util.Map;

public interface BookNoteService extends IService<BookNote> {

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取简单对象
     *
     * @param bookNoteId
     * @return
     */
    BookNoteVo getSimpleBookNoteVo(Integer bookNoteId);

    /**
     * 获取简单List
     *
     * @param bookId
     * @return
     */
    List<BookNote> listSimpleBookNote(Integer bookId);
}
