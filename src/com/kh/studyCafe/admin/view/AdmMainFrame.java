package com.kh.studyCafe.admin.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;


public class AdmMainFrame extends JFrame implements ActionListener{
	private ClientBack client = new ClientBack(); // 클라이언트 백그라운드 생성
	private static String ipName;
	
	// 메인 프레임
	public AdmMainFrame() {
		this.setBounds(0, 0, 978, 700); 
		this.setLayout(null);
		
		new AdmLoginMain(this); // 프로그램 실행 시 첫번째 페이지
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			ipName = InetAddress.getLocalHost().getHostAddress();
			client.setIpName(ipName);
			client.connect();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		new AdmMainFrame();
		
	}
	public void appendUser(ArrayList<User> user) {
		new AdmDao().admWrite(user);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
