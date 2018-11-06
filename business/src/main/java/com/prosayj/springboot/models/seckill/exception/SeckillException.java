package com.prosayj.springboot.models.seckill.exception;

/**
 * 秒杀相关业务异常
 * 需要注意的是：spring的声明式事物只接受运行期异常回滚策略，非运行期异常是不回滚的。
 */
public class SeckillException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -108695138263138524L;

	public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
