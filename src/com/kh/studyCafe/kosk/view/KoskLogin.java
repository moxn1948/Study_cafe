package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
 
public class KoskLogin extends JPanel{
	private KoskMainFrame mf;
	private JPanel mainpage;
	
	public KoskLogin(KoskMainFrame mf) {
		this.mf = mf; 
		mainpage = this;
		
		//======= 색상 설정 ====
		
		Color wallPapers = new Color(239,234,222); //諛곌꼍�깋
		Color textColor = new Color(127,118,104); //湲��옄�깋
		
		//=================
		
		
		//================ 패널 설정 ======================
		this.setSize(360,640);
		this.setLayout(null);
		this.setBackground(wallPapers);
		//================================================
		
		//============== font 폰트 설정 =========
		
		Font f1 = new Font("",Font.BOLD,25);
		
		//============================
		
		// panel 크占쏙옙 占쏙옙占쏙옙
		
		//============== 占쏙옙占쏙옙 占쏙옙占쏙옙 占싸븝옙 ========================
		
		JLabel title1 = new JLabel("스터디카페를 다니고");
		JLabel title2 = new JLabel("나의 성공 시대 ");
		JLabel title3 = new JLabel("시작됐다");
		
		title1.setBounds(65,150,600,60);// 크占쏙옙 占쏙옙占쏙옙
		title1.setForeground(textColor);// 占쏙옙占쏙옙
		title2.setBounds(65,180,600,60);
		title2.setForeground(textColor);
		title3.setBounds(65,210,600,60);
		title3.setForeground(textColor);
		
		// font 占쏙옙占쏙옙
		title1.setFont(f1);
		title2.setFont(f1);
		title3.setFont(f1);
		//=================================================
		
		//==================== 占쌔쏙옙트 占십듸옙 占쏙옙占쏙옙 ==============
		
		JTextField phonenumber = new JTextField("Phone Number");
		JTextField password = new JTextField("password.");
		
		phonenumber.setBounds(65,275,230,40);
		phonenumber.setLayout(null);
		password.setBounds(65,320,230,40);
		password.setLayout(null);
		
		
		
		//===================================================
		
		//===============  占쏙옙튼 占쏙옙占쏙옙 =================
		
		Image loginicon = new ImageIcon("img/loginimg.png").getImage().getScaledInstance(230, 50, 0);
		Image singUpicon = new ImageIcon("img/singUpimg.png").getImage().getScaledInstance(110, 40, 0);
		Image findPwdicon = new ImageIcon("img/findPwdimg.png").getImage().getScaledInstance(110, 40, 0);
		
		JButton loginButton = new JButton(new ImageIcon(loginicon));
		JButton signUp = new JButton(new ImageIcon(singUpicon));
		JButton findPwd = new JButton(new ImageIcon(findPwdicon));
		findPwd.setBorderPainted(false);
		
		loginButton.setBounds(65,365,230,50); //占싸깍옙占쏙옙 占쏙옙튼 크占쏙옙 占쏙옙占쏙옙
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
		mf.add(this);
		
		findPwd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, mainpage, new KoskMypage());
			}
		});
	
		signUp.addActionListener(new MyActionListener());
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(mf, mainpage, new KoskGroupPanel());
			
		}	
	}
	
}
