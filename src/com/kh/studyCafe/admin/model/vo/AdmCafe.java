package com.kh.studyCafe.admin.model.vo;

import java.io.Serializable;
import java.util.Calendar;

//implements 수정함
public class AdmCafe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 669863668942436805L;
	private int totalDaySales;
	private int totalMonthSales;
	private int totalUserAmount;
	private int day;
	private int month;
	
	public AdmCafe() {}
	
	public AdmCafe(int totalDaySales, int totalMonthSales, int totalUserAmount) {
		super();
		this.totalDaySales = totalDaySales;
		this.totalMonthSales = totalMonthSales;
		this.totalUserAmount = totalUserAmount;
		day = 0;
		month = 0;
	}
	

	public int getTotalDaySales() {
		return totalDaySales;
	}
	public void setTotalDaySales(int totalDaySales) {
		this.totalDaySales = totalDaySales;
	}
	public int getTotalMonthSales() {
		return totalMonthSales;
	}
	public void setTotalMonthSales(int totalMonthSales) {
		this.totalMonthSales = totalMonthSales;
	}
	public int getTotalUserAmount() {
		return totalUserAmount;
	}
	public void setTotalUserAmount(int totalUserAmount) {
		this.totalUserAmount = totalUserAmount;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
}
