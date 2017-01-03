package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by shou on 2016/12/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/springDao.xml"})
public class tmpUserDaoTest {
    @Resource
    private tmpUserDao tmp;
    @Test
    public void selectUser() throws Exception {
      System.out.print(tmp.query(1));
    }
}