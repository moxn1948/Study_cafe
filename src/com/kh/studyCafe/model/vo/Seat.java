package com.kh.studyCafe.model.vo;

import java.util.Date;

public class Seat extends User{
	private String seatName;
	private boolean isUsingSeat;
	
	public Seat(String seatName, boolean isUsingSeat) {
		super();
		this.seatName = seatName;
		this.isUsingSeat = isUsingSeat;
	}
	
	public Seat(String name, Date inTime, Date outTime, int seatType, String seatName, boolean isUsingSeat) {
		super(name, inTime, outTime, seatType);
		this.seatName = seatName;
		this.isUsingSeat = isUsingSeat;
	}
	
	// setter, getter
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public boolean isUsingSeat() {
		return isUsingSeat;
	}
	public void setUsingSeat(boolean isUsingSeat) {
		this.isUsingSeat = isUsingSeat;
	}
	
	

}
