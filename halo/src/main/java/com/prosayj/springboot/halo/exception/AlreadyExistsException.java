package com.prosayj.springboot.halo.exception;

/**
 * Exception caused by entity existence already.
 *
 * @author ProSayJ
 */
public class AlreadyExistsException extends BadRequestException {

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
