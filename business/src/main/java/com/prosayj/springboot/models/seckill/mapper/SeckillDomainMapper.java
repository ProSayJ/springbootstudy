package com.prosayj.springboot.models.seckill.mapper;

import com.prosayj.springboot.models.seckill.domain.SeckillDomain;

public interface SeckillDomainMapper {
    int deleteByPrimaryKey(Long seckillId);

    int insert(SeckillDomain record);

    int insertSelective(SeckillDomain record);

    SeckillDomain selectByPrimaryKey(Long seckillId);

    int updateByPrimaryKeySelective(SeckillDomain record);

    int updateByPrimaryKey(SeckillDomain record);
}