package com.prosayj.springboot.models.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 */
public class RepeatKillException extends SeckillException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7588706798824576584L;

	public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }



}
