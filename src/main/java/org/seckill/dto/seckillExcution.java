package org.seckill.dto;

import org.seckill.SeckillStatEnum.SeckillStatEnum;
import org.seckill.entity.SuccessKilled;

/**
 * Created by shou on 2016/12/27.
 */
public class seckillExcution {
    private int seckillId;
    private int state;
    //状态
    private String stateInfo;
    //秒杀成功对象
    private SuccessKilled successKilled;

    public seckillExcution(int seckillId, SeckillStatEnum enmu, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = enmu.getState();
        this.stateInfo = enmu.getStateInfo();
        this.successKilled = successKilled;
    }

    public seckillExcution(int seckillId,SeckillStatEnum enmu ) {
        this.seckillId = seckillId;
        this.state = enmu.getState();
        this.stateInfo = enmu.getStateInfo();
    }

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "seckillExcution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}
