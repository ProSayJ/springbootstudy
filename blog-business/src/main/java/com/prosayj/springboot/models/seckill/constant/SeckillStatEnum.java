package com.prosayj.springboot.models.seckill.constant;

/**
 * 使用枚举标识常量数据：
 * 数据字典放到枚举当中
 */
public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ORROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");
    private int state;
    private String stateInfo;

    
    
    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
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

    public static  SeckillStatEnum stateOf(int index){
    	//枚举内部的values()方法用于拿到所有的类型
        for(SeckillStatEnum state: values()){
            if(state.getState()==index){
                return state;
            }
        }
        return  null;
    }

}
