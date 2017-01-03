package org.seckill.entity;

import java.util.Date;

public class SuccessKilled {
	private int seckill_id;
	private int user_Phone;
	private short state;
	private Date create_Time;

	private Seckill seckill;
	public short getState() {
		return state;
	}
	public void setState(short state) {
		this.state = state;
	}

	public int getSeckill_id() {
		return seckill_id;
	}

	public void setSeckill_id(int seckill_id) {
		this.seckill_id = seckill_id;
	}

	public int getUser_Phone() {
		return user_Phone;
	}

	public void setUser_Phone(int user_Phone) {
		this.user_Phone = user_Phone;
	}

	public Date getCreate_Time() {
		return create_Time;
	}

	public void setCreate_Time(Date create_Time) {
		this.create_Time = create_Time;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessKilled{" +
				"seckill_id=" + seckill_id +
				", user_Phone=" + user_Phone +
				", state=" + state +
				", create_Time=" + create_Time +
				", seckill=" + seckill.toString()+
				'}';
	}
}
