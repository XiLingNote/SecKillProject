package org.seckill.service.impl;

import org.seckill.SeckillStatEnum.SeckillStatEnum;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.seckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.exception.RepeatKillExcetion;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.seckill.service.SeckillService;

import java.util.Date;
import java.util.List;

/**
 * Created by shou on 2016/12/27.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    //注入service依赖
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;
    //md5
    private final String slat="qwerqrweqtjio1423129034";

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }
    public Seckill getById(int seckillId) {
        return seckillDao.queryById(seckillId);
    }
    public Exposer exportSeckillUrl                                                                                                                                                                                                                                                                      (int seckillId) {
        Seckill seckill =seckillDao.queryById(seckillId);
        if (seckill == null) {
         return new Exposer(false,seckillId);
        }
        Date startTime=seckill.getSTART_TIME();
        Date endTime=seckill.getEND_TIME();
        Date nowTime=new Date();
        if (nowTime.getTime()<startTime.getTime()||nowTime.getTime()>endTime.getTime()) {
            return new Exposer(false, nowTime.getTime(), startTime.getTime(), endTime.getTime(), seckillId);
        }
        //转换特定字符串，不可逆操作
        String md5=getMD5(seckillId);
        return new Exposer(true,md5,seckillId);
    }

    /**
     * 加密方法
     * @param seckillId
     * @return
     */
    private String getMD5(int seckillId){
        String base=seckillId+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return  md5;
    }
    @Transactional
    /**
     * 使用注解的有点
     * 1.开发团队一致性约定，明确标注
     * 2.确保事务执行时间短不要穿插其他网络操作请求，或者剥离到事务外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作不需要事务
     */
    public seckillExcution excuteSeckill(int seckillId, int userPhone, String md5) throws SeckillException, SeckillCloseException, RepeatKillExcetion {
        Date nowTime=new Date();
        if (md5==null||!md5.equals(getMD5(seckillId))){
          throw  new SeckillException("seckillId date rewrite");
        }
        //秒杀业务逻辑：减库存
    try {
        int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
        if (updateCount <= 0) {
            throw new SeckillCloseException("seckill  is  closed");
        } else {
            //记录购买行为
            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            if (insertCount <= 0) {
                throw new RepeatKillExcetion("seckill repeate");
            } else {
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId);
                return new seckillExcution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
            }
        }
    }catch(SeckillCloseException e1){
            throw e1;
        }
        catch(RepeatKillExcetion e2){
            throw e2;
        }
    catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("seckill inner error"+e.getMessage());
    }
    }
}
