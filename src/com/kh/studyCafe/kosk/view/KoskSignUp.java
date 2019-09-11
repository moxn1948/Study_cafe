package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.controller.KoskManager;
import com.kh.studyCafe.kosk.view.popup.KoskPassWordNo;
import com.kh.studyCafe.kosk.view.popup.KoskSignUpCancle;
import com.kh.studyCafe.kosk.view.popup.KoskSignUpPop;
  
public class KoskSignUp extends JPanel{

	
	private JPanel Sign = new JPanel();
	private KoskMainFrame mf;
	private JPanel pp4 = new JPanel();
	private String nam;
	private String ph;
	private String ps;
	private String pss;
	

	// 네트워크 코드
	private ClientBack client;
	
	public KoskSignUp(KoskMainFrame mf, ClientBack client) {
		this.mf = mf;
		
		// 네트워크 코드
		this.client = client;

		JPanel pp =new JPanel();
		JPanel pp2 = new JPanel();
		JPanel pp3 = new JPanel();
		

		//===== 컬러 설정 =====
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);
				 
		//==================
				   
		
		//===== JPanel 설정 =======
		pp.setLayout(null);
		pp.setBackground(wallPapers);
		pp.setSize(360,640);
		
		
		//===========회원가입완료  팝업==========
		KoskSignUpPop ksp = new KoskSignUpPop();
		pp2.setLayout(null);
		pp2.setBounds(20, 100, 292, 200);
		pp2.add(ksp.KoskSignUpPop(mf));
		
		
		//===========회원취소 팝업 =============
		KoskSignUpCancle ksc = new KoskSignUpCancle();
		pp3.setLayout(null);
		pp3.setBounds(20, 100, 292, 200);
		pp3.add(ksc.KoskSignUpCancle(mf));
		
		
		
		//============ font 설정 ==========
		Font siguptext = new Font("맑은고딕",Font.BOLD,30);
		Font inputtext = new Font("맑은고딕",Font.BOLD,17);
		Font checktext = new Font("맑은고딕",Font.BOLD,14);
	
		//===============================
		
		//====== 로고 이미지아이콘 ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);
		ib.setBounds(150,0,50,50);
		//===============================
		
		//=======  제목 설정  ================
	   JLabel text = new JLabel("회원가입");
	   text.setBounds(110,80,150,50);
	   text.setLayout(null);
	   text.setFont(siguptext);
	   text.setForeground(textColor);
		//===================================
	
		//========= 라벨 설정 ===================
	   JLabel name = new JLabel("이름");
	   name.setBounds(30, 170, 40, 30);
	   name.setFont(inputtext);
	   name.setForeground(textColor);
	   
	   JLabel phnumber = new JLabel("휴대폰");
	   JLabel phnumber2 = new JLabel("번호");
	   phnumber.setBounds(30,230,60,30);
	   phnumber2.setBounds(30,250,60,30);
	   phnumber.setFont(inputtext);
	   phnumber2.setFont(inputtext);
	   phnumber.setForeground(textColor);
	   phnumber2.setForeground(textColor);
	   
	   JLabel psswd = new JLabel("비밀번호");
	   psswd.setBounds(30,310,80,30);
	   psswd.setForeground(textColor);
	   psswd.setFont(inputtext);
	   
	   JLabel psswdch = new JLabel("비밀번호");
	   JLabel psswdch2 = new JLabel("확인");
	   psswdch.setBounds(30, 370,80,30);
	   psswdch2.setBounds(30,390,60,30);
	   psswdch.setFont(inputtext);
	   psswdch2.setFont(inputtext);
	   psswdch.setForeground(textColor);
	   psswdch2.setForeground(textColor);
	   
	   JTextField nametf = new JTextField("");
	   nametf.setBounds(120,165,200,40);
	  // nametf.setEnabled(false);
	  // nametf.addMouseListener(null);
	   

	   JTextField phtf = new JTextField("");
	   phtf.setBounds(120,235,200,40);
//	   phtf.setEnabled(false);
//	   phtf.addMouseListener(null);
	   
	   
	   JTextField pstf = new JPasswordField("");
	   pstf.setBounds(120,305,200,40);
	   pstf.setEditable(true);
//	   pstf.setEnabled(false);
//	   pstf.addMouseListener(null);
	   
	   
	   
	   JTextField psch = new JPasswordField("");
	   psch.setBounds(120,375,200,40);
//	   psch.setEnabled(false);
//	   psch.addMouseListener(null);
	  
	   //===================================
	   
	 //==========비밀번호 불일치 팝업=========
	 		String num1 = pstf.getText();
	 		String num2 = psch.getText();
	 		if(num1.equals(num2)) {
	 			
	 			KoskPassWordNo ksn = new KoskPassWordNo();
	 			pp4.setLayout(null);
	 			pp4.setBounds(20, 100, 292, 200);
	 			pp4.add(ksn.KoskPassWordNo(mf));
	 			
	 			JButton button2 = new JButton("OK");
	 			button2.setBounds(5, 140, 280, 40);
	 			button2.setBackground(paper);
	 			button2.setForeground(paper1);
	 			pp4.add(button2,0);
	 			button2.addActionListener(new ActionListener() {
	 				
	 				@Override
	 				public void actionPerformed(ActionEvent e) {
	 					pp.remove(pp4);
	 					pp.repaint();
	 					mf.repaint();
	 					
	 				}
	 			});
	 			
	 		}
	   //====== cancel, confirm 버튼 설정 ========================
	   Image cancelbtn = new ImageIcon("img/cancelbtnimg.png").getImage().getScaledInstance(140, 50, 0);
	   Image confirmbtn = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(140, 50, 0);
	   	JButton cancel = new JButton(new ImageIcon(cancelbtn));
	   	cancel.setBounds(20,500,140,50);
		
	   	JButton confirm = new JButton(new ImageIcon(confirmbtn));
	   	confirm.setBounds(180,500,140,50);
	   	
	   //=================popup버튼 완료 설정==============
	   	
	   	JButton button = new JButton("OK");
	   	button.setBounds(5,140,280,40);
		button.setBackground(paper);
		button.setForeground(paper1);
		pp2.add(button,0);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pp.remove(pp2);
				pp.repaint();
				ChangePanel.changePanel(mf, pp,new KoskLogin(mf, client));
				mf.repaint();
			}
			
		});
		//===============Popup버튼 취소 설정==================
		JButton button1 = new JButton("OK");
		button1.setBounds(5,140,280,40);
		button1.setBackground(paper);
		button1.setForeground(paper1);
		pp3.add(button1,0);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pp.remove(pp3);
				pp.repaint();
				ChangePanel.changePanel(mf, pp, new KoskLogin(mf, client));
				mf.repaint();
				
			}
		});
	   //=============비밀번호 일치 버튼 ======================
		
		
		
	   	
	   	//====== 체크박스 설정 ======================
	   	JCheckBox checkbox = new JCheckBox("   [필수] 제 3자 이용자 동의 약관");
	   	checkbox.setBounds(40,450,400,30);
	   	checkbox.setBackground(wallPapers);
	   	checkbox.setFont(checktext);
	   	checkbox.setForeground(textColor);
	   	
	   	
	   	//====================================
		pp.add(text);
		pp.add(ib);
		pp.add(name);
		pp.add(nametf);
		pp.add(phnumber);
		pp.add(phnumber2);
		pp.add(phtf);
		pp.add(psswd);
		pp.add(pstf);
		pp.add(psswdch);
		pp.add(psswdch2);
		pp.add(psch);
		pp.add(cancel);
		pp.add(confirm);
		pp.add(checkbox);
		mf.add(pp);
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList number = new ArrayList();
				number.add(nametf.getText());
				number.add(phtf.getText());
				number.add(pstf.getText());
				number.add(psch.getText());
			    
				KoskManager km =  new KoskManager();
//				km.KoskSgin(number, client);
				if(km.KoskSgin(number, client) == true) {
					pp.add(pp2,0);
					mf.repaint();
				} else if(km.KoskSgin(number, client) == false){
					pp.add(pp4,0);
					mf.repaint();
				}

				
			}
			
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pp.add(pp3,0);
				mf.repaint();
				
			}
		});
		

	
	}
	
	
}
	

		

