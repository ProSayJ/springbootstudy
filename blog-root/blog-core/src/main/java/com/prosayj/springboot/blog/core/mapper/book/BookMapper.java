package com.prosayj.springboot.blog.core.mapper.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.book.vo.BookVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 图书表 Mapper 接口
 * </p>
 *
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    /**
     * 获取bookVo
     * @param page
     * @param params
     * @return
     */
    List<BookVo> listBookVo(Page<BookVo> page, @Param("params") Map<String, Object> params);

    /**
     * 根据条件查询分页
     * @param page
     * @param params
     * @return
     */
    List<BookVo> queryPageCondition(Page<BookVo> page, @Param("params") Map<String, Object> params);

    /**
     * 更新阅读记录
     * @param id
     */
    void updateReadNum(int id);

    /**
     * 更新点赞记录
     * @param parseInt
     */
    void updateLikeNum(int parseInt);

    /**
     * 判断类别下是否有图书
     * @param categoryId
     * @return
     */
    int checkByCategory(Integer categoryId);
}
