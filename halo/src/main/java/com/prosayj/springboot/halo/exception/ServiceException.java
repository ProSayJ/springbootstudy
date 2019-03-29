package com.prosayj.springboot.halo.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception caused by service.
 *
 * @author ProSayJ
 */
public class ServiceException extends HaloException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
