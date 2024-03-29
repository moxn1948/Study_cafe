package com.kh.studyCafe.model.vo;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2919301810429862199L;
	
	private String name; // 회원이름
	private String phoneNum; // 전화번호
	private String password; // 비밀번호
	private String seatNum; // 좌석번호
	private long inTime; // 입실시간
	private long outTime; // 퇴실시간
	private long remainTime; // 남은시간
	public final static int NOSEAT = 0; // 좌석 사용 안할 때
	public final static int HOURSEAT = 1; // 1일권 사용할 때
	public final static int WEEKSEAT = 2; // 기간권 사용할 때
	private int seatType; // 시트타입
//	private int point; // 포인트
	private long pointTime; // 누적 결제시간
	private String rank; // 등급
	private int totalSales;
	
	public User() {}
	
	public User(String name, String phoneNum, String password) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.password = password;
		this.seatNum = "0";
		this.inTime = 0;
		this.outTime = 0;
		this.remainTime = 0;
		this.seatType = NOSEAT;
//		this.point = 0;
		this.pointTime = 0;
		this.rank = "bronze";
		this.totalSales = 0;
	}

	// 모든 필드 초기화 생성자
	public User(String name, String phoneNum, String password, String seatNum, long inTime, long outTime, long remainTime,
			int seatType, long pointTime, String rank) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.password = password;
		this.seatNum = seatNum;
		this.inTime = inTime;
		this.outTime = outTime;
		this.remainTime = remainTime;
		this.seatType = seatType;
//		this.point = point;
		this.pointTime = pointTime;
		this.rank = rank;
		this.totalSales = 0;
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

//	public int getPoint() {
//		return point;
//	}
//
//	public void setPoint(int point) {
//		this.point = point;
//	}
//	
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
	
	
	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNum=" + phoneNum + ", password=" + password + ", seatNum=" + seatNum
				+ ", inTime=" + inTime + ", outTime=" + outTime + ", remainTime=" + remainTime + ", seatType="
				+ seatType + ", pointTime=" + pointTime + ", rank=" + rank + ", totalSales=" + totalSales + "]";
	}
	
}
