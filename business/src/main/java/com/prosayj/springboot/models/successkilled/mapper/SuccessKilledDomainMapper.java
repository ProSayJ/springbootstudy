package com.prosayj.springboot.models.successkilled.mapper;

import com.prosayj.springboot.models.successkilled.domain.SuccessKilledDomain;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledDomainMapper {
    int deleteByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    int insert(SuccessKilledDomain record);

    int insertSelective(SuccessKilledDomain record);

    SuccessKilledDomain selectByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    int updateByPrimaryKeySelective(SuccessKilledDomain record);

    int updateByPrimaryKey(SuccessKilledDomain record);
}