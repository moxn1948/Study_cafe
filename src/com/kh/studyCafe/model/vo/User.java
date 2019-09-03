package com.kh.studyCafe.model.vo;

import java.util.Date;

public class User {
	private String name;
	private String phoneNum;
	private String password;
	private int seatNum;
	private Date inTime;
	private Date outTime;
	private Date remainTime;
	private final int NOSEAT = 0; // 좌석 사용 안할 때
	private final int INDVSEAT = 1; // 개인좌석 사용할 때
	private final int GRPSEAT = 2; // 그룹좌석 사용할 때
	private int seatType = NOSEAT;
	private int point;
	private Date pointTime; // 누적 결제시간
	private String rank;
	
	public User() {}
	
	public User(String name, Date inTime, Date outTime, int seatType) {
		super();
		this.name = name;
		this.inTime = inTime;
		this.outTime = outTime;
		this.seatType = seatType;
	}

	// 모든 필드 초기화 생성자
	public User(String name, String phoneNum, String password, int seatNum, Date inTime, Date outTime, Date remainTime,
			int seatType, int point, Date pointTime, String rank) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.password = password;
		this.seatNum = seatNum;
		this.inTime = inTime;
		this.outTime = outTime;
		this.remainTime = remainTime;
		this.seatType = seatType;
		this.point = point;
		this.pointTime = pointTime;
		this.rank = rank;
	}
	
	// setter, getter
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Date getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(Date remainTime) {
		this.remainTime = remainTime;
	}

	public int getSeatType() {
		return seatType;
	}

	public void setSeatType(int seatType) {
		this.seatType = seatType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public Date getPointTime() {
		return pointTime;
	}

	public void setPointTime(Date pointTime) {
		this.pointTime = pointTime;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
