package com.prosayj.springboot.toword.service;

import com.prosayj.springboot.toword.dto.Table;

import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:40
 * @since 1.0.0
 */
public interface WordService {
    Map<String, List<Table>> tableList(String var1);
}
