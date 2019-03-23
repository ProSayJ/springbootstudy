package com.prosayj.springboot.models.seckill.exception;

import com.prosayj.springboot.models.seckill.constant.SeckillStatEnum;
import com.prosayj.springboot.models.successkilled.dto.SuccessKilledDTO;

/**
 * 封装秒杀执行后的结果
 */
public class SeckillExecution {

    private long seckillId;

    //秒杀执行结果状态
    private int state;

    //状态的标识
    private String stateInfo;

    private SuccessKilledDTO successKilledDTO;

    public SeckillExecution(long seckillId, SeckillStatEnum stateEnum, SuccessKilledDTO successKilledDT) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilledDTO = successKilledDTO;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilledDTO getSuccessKilledDTO() {
        return successKilledDTO;
    }

    public void setSuccessKilledDTO(SuccessKilledDTO successKilledDTO) {
        this.successKilledDTO = successKilledDTO;
    }
}
