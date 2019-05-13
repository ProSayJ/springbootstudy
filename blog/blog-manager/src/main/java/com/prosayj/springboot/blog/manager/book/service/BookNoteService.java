package com.prosayj.springboot.blog.manager.book.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.core.entity.book.dto.BookNoteDto;

import java.util.Map;

/**
 * BookNoteAdminService
 *
 */
public interface BookNoteService extends IService<BookNote> {

    /**
     * 分页查询笔记列表
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存笔记笔记
     * @param blogBookNote
     */
    void saveBookNote(BookNoteDto blogBookNote);

    /**
     * 批量删除
     * @param bookNoteIds
     */
    void deleteBatch(Integer[] bookNoteIds);

    /**
     * 更新笔记
     * @param blogBookNote
     */
    void updateBookNote(BookNoteDto blogBookNote);

    /**
     * 获取笔记对象
     * @param bookNoteId
     * @return
     */
    BookNoteDto getBookNote(Integer bookNoteId);

    /**
     * 判断该类别下是否有笔记
     * @param categoryId
     * @return
     */
    boolean checkByCategory(Integer categoryId);
}
