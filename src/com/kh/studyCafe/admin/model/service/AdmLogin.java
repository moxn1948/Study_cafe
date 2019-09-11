package com.kh.studyCafe.admin.model.service;

import com.kh.studyCafe.admin.model.dao.AdmDao;

public class AdmLogin {
	//여기서 로그인 받아옴
	AdmDao ad = new AdmDao();
	
	//매개변수로 textfield값 받아와서 입력해 놓은 id와 pwd가 일치시 화면전환
	public boolean isLogincheck(String id,String pwd) {
		boolean result;
		//패널만들기
		//이때 id와pwd는 textfield로 입력받은값
		System.out.println(id+" "+pwd);
		
		//텍스트 파일 전체를 다 합쳐서 문자열로 읽어들인걸read에
		String read=ad.loginInforRead();
		//split으로 두개로 나누어줌(id/pwd)
		String aId = read.split(",")[0];
		String aPwd=read.split(",")[1];
		
		System.out.println(aId);
		System.out.println(aPwd);
		
		
		
		//여기서 dao를 호출해야하고 dao에서는 파일을 불러와야함
		//여기서 아이디 유효성검사
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
