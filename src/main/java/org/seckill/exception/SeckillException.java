package org.seckill.exception;

/**总体异常
 * Created by shou on 2016/12/27.
 */
public class SeckillException extends  RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillException(Throwable cause) {
        super(cause);
    }

    public SeckillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
