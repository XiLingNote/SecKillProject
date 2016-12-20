package org.seckill.entity;

import java.util.Date;

public class SeccessKilled {
	private int seckillid;
	private int userPhone;
	private short state;
	private Date createTime;
	
	private Seckill seckill;
	public int getSeckillid() {
		return seckillid;
	}
	public void setSeckillid(int seckillid) {
		this.seckillid = seckillid;
	}
	public int getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}
	public short getState() {
		return state;
	}
	public void setState(short state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
