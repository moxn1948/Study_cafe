package com.kh.studyCafe.admin.view;

import javax.swing.JFrame;

public class AdmMainFrame extends JFrame{
	
	// 메인 프레임
	public AdmMainFrame() {
		this.setBounds(0, 0, 978, 700); 
		this.setLayout(null);
		
		new AdmLoginMain(this); // 프로그램 실행 시 첫번째 페이지
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
