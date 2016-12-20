package org.seckill.entity;

import java.util.Date;

/**
 * @author shou
 *
 */
public class Seckill {
	private int seckillid;
	private String sec_name;
	private int sec_number;
	private Date StartTime;
	private Date EndTime;
	private Date createTime;
	public int getSeckillid() {
		return seckillid;
	}
	public void setSeckillid(int seckillid) {
		this.seckillid = seckillid;
	}
	public String getSec_name() {
		return sec_name;
	}
	public void setSec_name(String sec_name) {
		this.sec_name = sec_name;
	}
	public int getSec_number() {
		return sec_number;
	}
	public void setSec_number(int sec_number) {
		this.sec_number = sec_number;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
