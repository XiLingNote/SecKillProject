package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by shou on 2017/1/3.
 */
//加载spring的容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit 的配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:mybatis-config.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        successKilledDao.insertSuccessKilled(2,1234556);

    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        System.out.println(successKilledDao.queryByIdWithSeckill(3,1234123));
    }

}