package com.kh.studyCafe.kosk.model.service;

public class SignUpService {
	
	public boolean singupservice(String[] value) {
		
		if(value[2].equals(value[3])) {
			return true;
		} else {
			return false;
		}
		
	}

}

