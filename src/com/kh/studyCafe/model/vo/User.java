package com.kh.studyCafe.model.vo;

import java.io.Serializable;

public class User implements Serializable{

	private String name; // 회원이름
	private String phoneNum; // 전화번호
	private String password; // 비밀번호
	private String seatNum; // 좌석번호
	private long inTime; // 입실시간
	private long outTime; // 퇴실시간
	private long remainTime; // 남은시간
	public final static int NOSEAT = 0; // 좌석 사용 안할 때
	public final static int INDVSEAT = 1; // 개인좌석 사용할 때
	public final static int GRPSEAT = 2; // 그룹좌석 사용할 때
	private int seatType = NOSEAT; // 시트타입
	private int point; // 포인트
	private long pointTime; // 누적 결제시간
	private String rank; // 등급
	
	public User() {}
	
	public User(String name, long inTime, long outTime, int seatType) {
		super();
		this.name = name;
		this.inTime = inTime;
		this.outTime = outTime;
		this.seatType = seatType;
	}

	// 모든 필드 초기화 생성자
	public User(String name, String phoneNum, String password, String seatNum, long inTime, long outTime, long remainTime,
			int seatType, int point, long pointTime, String rank) {
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public long getPointTime() {
		return pointTime;
	}

	public void setPointTime(long pointTime) {
		this.pointTime = pointTime;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNum=" + phoneNum + ", password=" + password + ", seatNum=" + seatNum
				+ ", inTime=" + inTime + ", outTime=" + outTime + ", remainTime=" + remainTime + ", seatType="
				+ seatType + ", point=" + point + ", pointTime=" + pointTime + ", rank=" + rank + "]";
	}
	
}
