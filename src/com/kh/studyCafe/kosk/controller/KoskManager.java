package com.kh.studyCafe.kosk.controller;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.kh.studyCafe.kosk.view.popup.KoskPasswordDoNot;
import com.kh.studyCafe.model.service.SignUpService;

public class KoskManager {
	public KoskManager(ArrayList number2) { // KoskSignUp에서 정보를 받아옴
		Iterator it = (Iterator) number2.iterator();
		
		String[] value = new String[4]; // 0번부터 3번까지 순서대로 정보를 value에 저장함
		
		SignUpService ss = new SignUpService();
		ss.signupservice(value);
			BufferedWriter bw = null;
			if(ss.signupservice(value)== true) {
				
				try {
					bw = new BufferedWriter(new FileWriter("userlist.txt",true));
					bw.write(value[0]+"/");
					bw.write(value[1]+"/");
					bw.write(value[2]+"/");
					bw.write(value[3]+"\r\n");// 파일 입력하는 부분
				} catch (IOException e) {
					
					e.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			} else {
				new KoskPasswordDoNot(); // false 이면 팝업창 뜸
			}

		
		
		
		
		
		}
	}
