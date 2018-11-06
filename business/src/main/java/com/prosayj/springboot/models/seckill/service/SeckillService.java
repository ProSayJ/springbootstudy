package com.prosayj.springboot.models.seckill.service;

import com.prosayj.springboot.models.seckill.dto.ExposerDTO;
import com.prosayj.springboot.models.seckill.dto.SeckillDTO;
import com.prosayj.springboot.models.seckill.exception.RepeatKillException;
import com.prosayj.springboot.models.seckill.exception.SeckillCloseException;
import com.prosayj.springboot.models.seckill.exception.SeckillException;
import com.prosayj.springboot.models.seckill.exception.SeckillExecution;

import java.util.List;

/**
 * 业务接口：站在“使用者”角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return）
 *
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     * @return
     */
    List<SeckillDTO> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    SeckillDTO getById(long seckillId);


    /**
     * 秒杀开启时，输出秒杀接口的地址，
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
    ExposerDTO exportSeckillUrl(long seckillId);


    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);

}
