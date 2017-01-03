package org.seckill.exception;

/**重复秒杀异常
 * Created by shou on 2016/12/27.
 */
public class RepeatKillExcetion extends SeckillException{
    public RepeatKillExcetion(String message) {
        super(message);
    }

    public RepeatKillExcetion(String message, Throwable cause) {
        super(message, cause);
    }
}
