package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.view.AdmUsingUserList;
import com.kh.studyCafe.admin.view.ControlPanel;

 
 
public class  KoskLogin extends JPanel{
	private JPanel Login = new JPanel();
	private KoskMainFrame mf;
	private int resultphone;
	private int resultpassw;
	public KoskLogin(KoskMainFrame mf) {
		this.mf = mf;

		//======= 색상 설정 ====
		
		Color wallPapers = new Color(239,234,222); 
		Color textColor = new Color(127,118,104); 
		
		//=================
		
		
		//================ 패널 설정 ======================
		Login.setSize(360,640);
		Login.setLayout(null);
		Login.setBackground(wallPapers);
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
		JTextField password = new JPasswordField("Pawd");
		phonenumber.setEnabled(false);
		phonenumber.addMouseListener(null);
		phonenumber.setBounds(65,275,230,40);
		phonenumber.setLayout(null);
		
		password.setEnabled(false);
		password.addMouseListener(null);
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
		
		
		Login.add(title1);
		Login.add(title2);
		Login.add(title3);
		Login.add(phonenumber);
		Login.add(password);
		Login.add(loginButton);
		Login.add(findPwd);
		Login.add(signUp);
		
		mf.add(Login,0);
		
		Login.addMouseListener(null);
		
		
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ChangePanel.changePanel(mf, Login, new KoskSeatTable(mf));
				
			}
		});
		
		findPwd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				//ChangePanel.changePanel(Login, new KoskPsswdFind());

				ChangePanel.changePanel(mf, Login, new KoskPsswdFind(mf));
     
				
			}
		});
	
		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, Login, new KoskSignUp(mf));
				
			}
			
		});
		phonenumber.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getSource() == phonenumber) {
					if(resultphone == 0) {
						phonenumber.setText("");
						phonenumber.setEnabled(true);
						phonenumber.requestFocus();
						
						resultphone++;
					}	
					
				}
				
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


		});
		password.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == password) {
					if(resultpassw == 0) {
						password.setText("");
						password.setEnabled(true);
						password.requestFocus();
						
						resultpassw++;
					}	
					
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


		});
	


	
		
	}
	
	

		
}
	
	

