package org.seckill.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shou on 2016/12/17
 * 配置spring和junit整合junit 启动时加载spring.
 */
//加载spring的容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit 的配置文件位置
@ContextConfiguration({"classpath:spring/springDao.xml","classpath:mybatis-config.xml"})
public class SeckillDaoTest {

    //注入依赖
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        date = format.parse("2016-12-02");
        int a = seckillDao.reduceNumber(1, date);
        System.out.println(a);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> list=seckillDao.queryAll(0,3);
        System.out.println(JSON.toJSONString(list,true));
    }
    //通过
    @Test
    public void quereyById(){
        Seckill seckill=seckillDao.queryById( 1);
        System.out.print(seckill);
    }

}