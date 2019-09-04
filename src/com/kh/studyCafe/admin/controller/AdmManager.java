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
//		userInfo.usingUserInfo(u); // AdmUserInfoChk 리턴받아옴
		
		return userInfo.usingUserInfo(u);
	}

}
