package org.seckill.entity;

import java.util.Date;

/**
 * @author shou
 *
 */
public class Seckill {
	//SECKILL_ID, SEC_NAME, SEC_NUMBER, START_TIME, END_TIME, CREATE_TIME, ID
	private int SECKILL_ID;
	private String SEC_NAME;
	private int SEC_NUMBER;

	@Override
	public String toString() {
		return "Seckill{" +
				"SECKILL_ID=" + SECKILL_ID +
				", SEC_NAME='" + SEC_NAME + '\'' +
				", SEC_NUMBER=" + SEC_NUMBER +
				", START_TIME=" + START_TIME +
				", END_TIME=" + END_TIME +
				", CREATE_TIME=" + CREATE_TIME +
				", ID='" + ID + '\'' +
				'}';
	}

	private Date START_TIME;
	private Date END_TIME;
	private Date CREATE_TIME;
	private String ID;

	public int getSECKILL_ID() {
		return SECKILL_ID;
	}

	public void setSECKILL_ID(int SECKILL_ID) {
		this.SECKILL_ID = SECKILL_ID;
	}

	public String getSEC_NAME() {
		return SEC_NAME;
	}

	public void setSEC_NAME(String SEC_NAME) {
		this.SEC_NAME = SEC_NAME;
	}

	public int getSEC_NUMBER() {
		return SEC_NUMBER;
	}

	public void setSEC_NUMBER(int SEC_NUMBER) {
		this.SEC_NUMBER = SEC_NUMBER;
	}

	public Date getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(Date START_TIME) {
		this.START_TIME = START_TIME;
	}

	public Date getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(Date END_TIME) {
		this.END_TIME = END_TIME;
	}

	public Date getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(Date CREATE_TIME) {
		this.CREATE_TIME = CREATE_TIME;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}
