package com.prosayj.springboot.blog.models.image.temp.exception;

/**
 * @author wang.xw
 * @date 2018/8/6 19:24.
 */
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super();
    }

    public EmptyQueueException(String message) {
        super(message);
    }

    public EmptyQueueException(String message, Throwable cause) {
        super(message, cause);
    }
}
