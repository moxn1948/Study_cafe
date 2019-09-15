package com.kh.studyCafe.admin.model.service;

import com.kh.studyCafe.admin.model.dao.AdmDao;

public class AdmLogin {
	private AdmDao ad = new AdmDao();
	
	public boolean isLogincheck(String id,String pwd) {
		boolean result;
		
		String read=ad.loginInforRead();
		String aId = read.split(",")[0];
		String aPwd=read.split(",")[1];
		
		//아이디 유효성검사
		if(id.equals(aId)&&pwd.equals(aPwd)) {
			System.out.println("로그인 성공");
			result=true;
		}else {
			System.out.println("로그인 실패");
			result=false;
		}
		
		return result;
	}
	
}
