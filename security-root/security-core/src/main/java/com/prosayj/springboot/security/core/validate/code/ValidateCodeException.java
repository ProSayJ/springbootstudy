package com.prosayj.springboot.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author yangjian
 * @description
 * @Date 下午 11:25 2019/11/3
 * @since 1.0.0
 */
public class ValidateCodeException extends AuthenticationException {

    /**
     *
     */
    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
