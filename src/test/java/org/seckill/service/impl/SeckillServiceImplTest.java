package org.seckill.service.impl;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.seckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExcetion;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by shou on 2016/12/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info(JSON.toJSONString(list,true));
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1);
        logger.info(JSON.toJSONString(seckill,true));
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        int id=3;
        Exposer exposer=seckillService.exportSeckillUrl(id);

        if (exposer.isExposed()){
            logger.info("expose={}",exposer);
            int phone=41;
            String md5=exposer.getMd5();
            seckillExcution exception= null;
            try {
                exception = seckillService.excuteSeckill(id,phone,md5);
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }catch (RepeatKillExcetion e1){
                logger.error(e1.getMessage());
            }
            logger.info("result={}",exception);
        }else
        logger.info("expose={}",exposer);
    }

    @Test
    public void excuteSeckill() throws Exception {

    }

}