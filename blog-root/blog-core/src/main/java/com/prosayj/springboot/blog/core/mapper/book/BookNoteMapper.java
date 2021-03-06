package com.prosayj.springboot.blog.core.mapper.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.core.entity.book.vo.BookNoteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 笔记 Mapper 接口
 * </p>
 */
@Mapper
public interface BookNoteMapper extends BaseMapper<BookNote> {

    /**
     * 查询列表
     *
     * @param page
     * @param params
     * @return
     */
    List<BookNoteVo> listBookNoteVo(Page<BookNoteVo> page, @Param("params") Map<String, Object> params);

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    List<BookNoteVo> queryPageCondition(Page<BookNoteVo> page, @Param("params") Map<String, Object> params);

    /**
     * 更新阅读记录数
     *
     * @param id
     */
    void updateReadNum(Integer id);

    /**
     * 获取简单对象
     *
     * @param bookNoteId
     * @return
     */
    BookNoteVo getSimpleBookNoteVo(Integer bookNoteId);

    /**
     * 获取简单list
     *
     * @param bookId
     * @return
     */
    List<BookNote> listSimpleBookNote(Integer bookId);

    /**
     * 更新点赞记录
     *
     * @param parseInt
     */
    void updateLikeNum(int parseInt);

    /**
     * 判断该类别下是否有笔记
     *
     * @param categoryId
     * @return
     */
    int checkByCategory(Integer categoryId);
}
