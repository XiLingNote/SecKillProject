package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.seckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExcetion;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**业务接口:站在使用者角度
 * 三个方面：方法定义力度，参数，返回
 * Created by shou on 2016/12/27.
 */
public interface SeckillService {
    /**
     *  查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(int seckillId);

    /**
     * 秒杀开始时输出秒杀接口地址，否则输出系统时间何秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(int seckillId);
    /**
     *
     */
    seckillExcution excuteSeckill(int seckill, int userPhone, String md5) throws SeckillException,SeckillCloseException,RepeatKillExcetion;
}
