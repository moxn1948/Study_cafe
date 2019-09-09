package com.kh.studyCafe.model.service;

public class SignUpService {
	private boolean pwcht;
	public boolean signupservice(String[] value) {
		if(value[2].equals(value[3])){
			pwcht = true;
			return true;
		}else {
			pwcht = false;
			return false;
		}
		
		
	}


}
