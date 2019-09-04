package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.studyCafe.kosk.controller.KoskManager;
import com.kh.studyCafe.kosk.model.service.KoskLoginService;
 
 
public class KoskLogin extends JPanel{
	private JPanel Login;
	
	public KoskLogin() {
		Login = this;
		//======= 색상 설정 ====
		
		Color wallPapers = new Color(239,234,222); 
		Color textColor = new Color(127,118,104); 
		
		//=================
		
		
		//================ 패널 설정 ======================
		this.setSize(360,640);
		this.setLayout(null);
		this.setBackground(wallPapers);
		//================================================
		
		//============== font 폰트 설정 =========
		
		Font f1 = new Font("",Font.BOLD,25);
		
		//============================
		
		
		//============== 제목 설정 ========================
		
		JLabel title1 = new JLabel("스터디카페를 다니고");
		JLabel title2 = new JLabel("나의 성공 시대 ");
		JLabel title3 = new JLabel("시작됐다");
		
		title1.setBounds(65,150,600,60);
		title1.setForeground(textColor);
		title2.setBounds(65,180,600,60);
		title2.setForeground(textColor);
		title3.setBounds(65,210,600,60);
		title3.setForeground(textColor);
		
		// font 설정
		title1.setFont(f1);
		title2.setFont(f1);
		title3.setFont(f1);
		//=================================================
		
		//==================== 텍스트 필드 설정  ==============
		
		JTextField phonenumber = new JTextField("Phone Number");
		JTextField password = new JTextField("password.");
		
		phonenumber.setBounds(65,275,230,40);
		phonenumber.setLayout(null);
		password.setBounds(65,320,230,40);
		password.setLayout(null);
		
		
		
		//===================================================
		
		//===============  제목설정 =================
		
		Image loginicon = new ImageIcon("img/loginimg.png").getImage().getScaledInstance(230, 50, 0);
		Image singUpicon = new ImageIcon("img/singUpimg.png").getImage().getScaledInstance(110, 40, 0);
		Image findPwdicon = new ImageIcon("img/findPwdimg.png").getImage().getScaledInstance(110, 40, 0);
		
		JButton loginButton = new JButton(new ImageIcon(loginicon));
		JButton signUp = new JButton(new ImageIcon(singUpicon));
		JButton findPwd = new JButton(new ImageIcon(findPwdicon));
		findPwd.setBorderPainted(false);
		
		loginButton.setBounds(65,365,230,50); 
		signUp.setBounds(65,420,110,40);
		findPwd.setBounds(185,420,110,40);
		
		
		//=======================================
		
		
		this.add(title1);
		this.add(title2);
		this.add(title3);
		this.add(phonenumber);
		this.add(password);
		this.add(loginButton);
		this.add(findPwd);
		this.add(signUp);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ChangePanel.changePanel(Login, new KoskSeatTable());
				
			}
		});
		
		findPwd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(Login, new KoskPsswdFind());
			}
		});
	
		signUp.addActionListener(new MyActionListener());
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(Login, new KoskSignUp());
			
		}
	}
	
}
