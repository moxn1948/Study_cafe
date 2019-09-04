package com.kh.studyCafe.model.service;

public class SignUpService {
	public boolean signupservice(String[] value) {
		if(value[2].equals(value[3])){
			return true;
		}else {
			return false;
		}
		
		
	}

}
