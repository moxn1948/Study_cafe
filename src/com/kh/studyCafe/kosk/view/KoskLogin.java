package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.model.vo.User;

 
 
public class  KoskLogin extends JPanel implements ActionListener, MouseListener{
	private KoskMainFrame mf;
	// 네크워크 코드
	private ClientBack client;
	
	private int compareNum;
	private JButton login;
	private JButton signUp;
	private JButton findPwd;
	private JTextField phoneNumber;
	private JTextField password;
	private int length;
	public KoskLogin(KoskMainFrame mf, ClientBack client) {
		// 네크워크 코드
		this.client = client;
		this.mf = mf;
		
		ArrayList userList = new ArrayList<>();
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
		
		Font f1 = new Font("맑은 고딕",Font.BOLD,25);
		
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
		
		phoneNumber = new JTextField("Phone Number");
		
		phoneNumber.setBounds(65,275,230,40);
		phoneNumber.setLayout(null);
		
		password = new JPasswordField("Pawd");
		password.setBounds(65,320,230,40);
		password.setLayout(null);
		//===================================================
		
		//===============  제목설정 =================
		
		Image loginicon = new ImageIcon("img/loginimg.png").getImage().getScaledInstance(230, 50, 0);
		Image singUpicon = new ImageIcon("img/singUpimg.png").getImage().getScaledInstance(110, 40, 0);
		Image findPwdicon = new ImageIcon("img/findPwdimg.png").getImage().getScaledInstance(110, 40, 0);
		
		login = new JButton(new ImageIcon(loginicon));
		signUp = new JButton(new ImageIcon(singUpicon));
		findPwd = new JButton(new ImageIcon(findPwdicon));
		findPwd.setBorderPainted(false);
		
		login.setBounds(65,365,230,50); 
		signUp.setBounds(65,420,110,40);
		findPwd.setBounds(185,420,110,40);
		login.addActionListener(this);
		findPwd.addActionListener(this);
		signUp.addActionListener(this);
		phoneNumber.addMouseListener(this);
		password.addMouseListener(this);
		//=======================================
				
		this.add(title1);
		this.add(title2);
		this.add(title3);
		this.add(phoneNumber);
		this.add(password);
		this.add(login);
		this.add(findPwd);
		this.add(signUp);
		
		mf.add(this,0);
		mf.repaint();
	}
				
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			KoskDao kd = new KoskDao();
			String phoneNum = phoneNumber.getText();
			ArrayList<User> uList;
			uList = kd.uList();
//			uList.get(kd.userindex(phoneNum)).setSeatNum("0");
//			kd.KoskWrite(uList);
			String light = (uList.get(kd.userindex(phoneNum)).getSeatNum());
			long seattime = uList.get(kd.userindex(phoneNum)).getRemainTime();
			System.out.println(uList);
			
			if(kd.login(phoneNumber.getText(), password.getText()) == 1) {
				 ChangePanel.changePanel(mf, this, new KoskSeatManagement(mf, uList,phoneNum,client,this,light,seattime));
			}else if(kd.login(phoneNumber.getText(), password.getText()) == 2) {
				ChangePanel.changePanel(mf, this, new KoskSeatTable2(mf,uList, client,phoneNum));
			}
		}
		if(e.getSource() == signUp) {
			ChangePanel.changePanel(mf, this, new KoskSignUp(mf, client));
		}
		if(e.getSource() == findPwd) {
			ChangePanel.changePanel(mf, this, new KoskPsswdFind(mf));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == password) {
			if(length == 0) {
				password.setText("");
				password.setEditable(true);
				password.requestFocus();
				password.selectAll();
				
				length++;
			}
		}
		length = 0;
		
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
		if(e.getSource() == phoneNumber) {
			if(length == 0) {
				phoneNumber.setText("");
				phoneNumber.setEditable(true);
				phoneNumber.requestFocus();
				phoneNumber.selectAll();
				
				length++;
			}
			
		}
		
		
	}
	
}
	
	

