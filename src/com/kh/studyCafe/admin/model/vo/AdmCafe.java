package com.kh.studyCafe.admin.model.vo;

public class AdmCafe {
	private int totalDaySales;
	private int totalMonthSales;
	private int totalUserAmount;
	
	public AdmCafe(int totalDaySales, int totalMonthSales, int totalUserAmount) {
		super();
		this.totalDaySales = totalDaySales;
		this.totalMonthSales = totalMonthSales;
		this.totalUserAmount = totalUserAmount;
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
	
}