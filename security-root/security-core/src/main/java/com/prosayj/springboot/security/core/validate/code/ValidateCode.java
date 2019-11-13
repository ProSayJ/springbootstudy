//package com.prosayj.springboot.security.core.validate.code;
//
//import java.time.LocalDateTime;
//
//
///**
// * @author yangjian
// * @description
// * @Date 下午 11:20 2019/11/3
// * @since 1.0.0
// */
//public class ValidateCode {
//
//    private String code;
//
//    private LocalDateTime expireTime;
//
//    public ValidateCode(String code, int expireIn) {
//        this.code = code;
//        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
//    }
//
//    public ValidateCode(String code, LocalDateTime expireTime) {
//        this.code = code;
//        this.expireTime = expireTime;
//    }
//
//    public boolean isExpried() {
//        return LocalDateTime.now().isAfter(expireTime);
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public LocalDateTime getExpireTime() {
//        return expireTime;
//    }
//
//    public void setExpireTime(LocalDateTime expireTime) {
//        this.expireTime = expireTime;
//    }
//
//}
