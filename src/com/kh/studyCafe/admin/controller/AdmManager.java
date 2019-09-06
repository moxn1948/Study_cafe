package com.kh.studyCafe.admin.controller;

import java.util.ArrayList;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.service.AdmUserInfoChk;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.model.vo.User;

public class AdmManager {
	private AdmDao ad = new AdmDao();
	
	public ArrayList<AdmUserTable> usingUserManager() {
		ArrayList<User> u = ad.admRead();
		AdmUserInfoChk userInfo = new AdmUserInfoChk(); 
		
		return userInfo.usingUserInfo(u);
	}
	
	public String findPhoneToName(String phoneNum) {
		ArrayList<User> u = ad.admRead();
		AdmUserInfoChk userInfo = new AdmUserInfoChk(); 
		
		return userInfo.toPhoneInfo(phoneNum, u);
	}
	
	public long findPhoneToRemain(String phoneNum) {
		ArrayList<User> u = ad.admRead();
		AdmUserInfoChk userInfo = new AdmUserInfoChk(); 
		
		return userInfo.toRemainInfo(phoneNum, u);
	}
	
	public ArrayList<User> addRemainTime(String name, int term) {
		return ad.admReadLine(name, term);
	}
}
