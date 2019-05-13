package com.prosayj.springboot.blog.core.common.exception;

import com.prosayj.springboot.blog.core.common.exception.enums.ErrorEnum;
import lombok.Data;


/**
 * @author yangjian
 * @description 自定义异常
 * @Date 18:04 2019/5/10
 * @since 1.0.0
 */
@Data
public class MyException extends RuntimeException {
    private String msg;
    private int code = 500;

    public MyException() {
        super(ErrorEnum.UNKNOWN.getMsg());
        this.msg = ErrorEnum.UNKNOWN.getMsg();
    }


    public MyException(ErrorEnum eEnum, Throwable e) {
        super(eEnum.getMsg(), e);
        this.msg = eEnum.getMsg();
        this.code = eEnum.getCode();
    }

    public MyException(ErrorEnum eEnum) {
        this.msg = eEnum.getMsg();
        this.code = eEnum.getCode();
    }

    public MyException(String exception) {
        this.msg = exception;
    }

}
