package com.kh.studyCafe.admin.model.vo;

import com.kh.studyCafe.model.vo.User;

public class AdmUserTable {
	private String name; // 회원이름
	private String phoneNum; // 전화번호
	private String seatNum; // 좌석번호
	private long inTime; // 입실시간
	private long outTime; // 퇴실시간
	private long remainTime; // 남은시간
	private int seatType; // 시트타입

	public AdmUserTable() {}

	public AdmUserTable(String name, String phoneNum, String seatNum, long inTime, long outTime,
			long remainTime, int seatType) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.seatNum = seatNum;
		this.inTime = inTime;
		this.outTime = outTime;
		this.remainTime = remainTime;
		this.seatType = seatType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public long getInTime() {
		return inTime;
	}

	public void setInTime(long inTime) {
		this.inTime = inTime;
	}

	public long getOutTime() {
		return outTime;
	}

	public void setOutTime(long outTime) {
		this.outTime = outTime;
	}

	public long getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(long remainTime) {
		this.remainTime = remainTime;
	}

	public int getSeatType() {
		return seatType;
	}

	public void setSeatType(int seatType) {
		this.seatType = seatType;
	}

	@Override
	public String toString() {
		return "AdmUserTable [name=" + name + ", phoneNum=" + phoneNum + ", seatNum="
				+ seatNum + ", inTime=" + inTime + ", outTime=" + outTime + ", remainTime=" + remainTime + ", seatType="
				+ seatType + "]";
	}
	
}
