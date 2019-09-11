package com.kh.studyCafe.admin.controller;

import java.util.ArrayList;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.service.AdmLogin;
import com.kh.studyCafe.admin.model.service.AdmUserInfoChk;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.model.vo.User;

public class AdmManager {
	private AdmDao ad = new AdmDao();

	public ArrayList<AdmUserTable> usingUserManager() {
		ArrayList<User> u = ad.admRead();
		System.out.println(u);
		AdmUserInfoChk userInfo = new AdmUserInfoChk(); 

		return userInfo.usingUserInfo(u);
	}

	/*
	 * public String findPhoneToName(String phoneNum) { ArrayList<User> u =
	 * ad.admRead(); AdmUserInfoChk userInfo = new AdmUserInfoChk();
	 * 
	 * return userInfo.toPhoneInfo(phoneNum, u); }
	 */

	public long findPhoneToRemain(String phoneNum) {
		ArrayList<User> u = ad.admRead();
		AdmUserInfoChk userInfo = new AdmUserInfoChk(); 

		return userInfo.toRemainInfo(phoneNum, u);
	}

	public ArrayList<User> addRemainTime(String phoneNum, int term) {
		return ad.admReadLine(phoneNum, term);
	}
	public ArrayList<User> enterSeatIndv(String phoneNum,int term, String seatNum) {
		return ad.admEnterSeatIndv(phoneNum, term, seatNum);
	}

	public ArrayList<User> moveSeatNum(String phoneNum, String seatNum) {
		return ad.admLineSeat(phoneNum, seatNum);
	}
	public ArrayList<User> exitSeatTime(String phoneNum) {
		return ad.admExitSeat(phoneNum);
	}
	public ArrayList<User> enterSeatTime(String phoneNum) {
		return ad.admEnterSeat(phoneNum);
	}
	public ArrayList<User> addWeekRemainTime(String phoneNum, int term) {
		return ad.admWeekReadLine(phoneNum, term);
	}
	//admLoginMain에서 넘긴걸 받아옴
	public boolean logpass(String id,String pwd) {
		AdmLogin al = new AdmLogin();
		return al.isLogincheck(id,pwd);
		
	}
}
