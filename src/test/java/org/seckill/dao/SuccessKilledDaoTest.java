package org.seckill.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by shou on 2017/1/3.
 */
//加载spring的容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit 的配置文件位置
@ContextConfiguration({"classpath:spring/springDao.xml","classpath:mybatis-config.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        successKilledDao.insertSuccessKilled(2,1234556);

    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        System.out.println(successKilledDao.queryByIdWithSeckill(3));
    }

}