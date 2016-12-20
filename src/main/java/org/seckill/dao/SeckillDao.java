package org.seckill.dao;

import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;


public interface SeckillDao {

int reduceNumber(int seckillId, Date killTime);

Seckill queryById(int seckillId);
List<Seckill> queryAll(int offet, int limit);
}
