package com.prosayj.springboot.halo.repository;

import com.prosayj.springboot.halo.model.domain.Options;
import com.prosayj.springboot.halo.repository.base.BaseRepository;

/**
 * <pre>
 *     系统设置持久层
 * </pre>
 *
 * @author : ProSayJ
 * @date : 2017/11/14
 */
public interface OptionsRepository extends BaseRepository<Options, String> {

    /**
     * 根据key查询单个option
     *
     * @param key key
     * @return Options
     */
    Options findOptionsByOptionName(String key);
}
