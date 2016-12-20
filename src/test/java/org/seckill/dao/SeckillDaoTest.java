package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by shou on 2016/12/17
 * 配置spring和junit整合junit 启动时加载spring.
 */
//加载spring的容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit 的配置文件位置
@ContextConfiguration({"classpath:spring/springDao.xml"})
public class SeckillDaoTest {
    //注入依赖
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void queryById() throws Exception {
        int id=1000;
        Seckill seckill=seckillDao.queryById(id);
    }


}