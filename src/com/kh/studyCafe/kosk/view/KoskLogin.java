package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.studyCafe.admin.model.dao.AdmDao;
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
		Color wallPapers = new Color(247,244,240); 
		Color textColor = new Color(127, 118, 104);
		//=================
		
		//================ 패널 설정 ======================
		this.setSize(360,640);
		this.setLayout(null);
		this.setBackground(wallPapers);
		//================================================
		
		//============== font 폰트 설정 =========
		
		Font f1 = new Font("맑은 고딕",Font.BOLD,32);
		
		//============================
		
		//============== 제목 설정 ========================
		
		JLabel title1 = new JLabel("<html><p>스터디카페 다니고<br>나의 성공시대<br>시작됐다</p></html>");
		
		title1.setBounds(41, 130, 280, 130);
		title1.setForeground(textColor);
		
		// font 설정
		title1.setFont(f1);
		//=================================================
		
		//==================== 텍스트 필드 설정  ==============
		phoneNumber = new JTextField("Phone Number");
		phoneNumber.setBounds(41,275,270,40);
		phoneNumber.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		phoneNumber.setLayout(null);
		
		password = new JPasswordField("password");
		password.setBounds(41,320,270,40);
		password.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		password.setLayout(null);
		//===================================================
		
		//===============  제목설정 =================
		login = new JButton("LOGIN");
		signUp = new JButton("회원가입");
		findPwd = new JButton("비밀번호 찾기");
		
		login.setBounds(41,370,270,50); 
		login.setBackground(new Color(163, 152, 134));
		login.setForeground(Color.WHITE);
		login.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		login.setBorderPainted(false);
		
		signUp.setBounds(41,426,132,40);
		signUp.setBackground(new Color(189, 177, 157));
		signUp.setForeground(Color.WHITE);
		signUp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		signUp.setBorderPainted(false);
		
		findPwd.setBounds(179,426,132,40);
		findPwd.setBackground(new Color(189, 177, 157));
		findPwd.setForeground(Color.WHITE);
		findPwd.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		findPwd.setBorderPainted(false);
		
		login.addActionListener(this);
		findPwd.addActionListener(this);
		signUp.addActionListener(this);
		phoneNumber.addMouseListener(this);
		password.addMouseListener(this);
		//=======================================
				
		this.add(title1);
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
			String light = (uList.get(kd.userindex(phoneNum)).getSeatNum());
			long seattime = uList.get(kd.userindex(phoneNum)).getRemainTime();
			System.out.println(uList);
			
			if(kd.login(phoneNumber.getText(), password.getText()) == 1) { // 이미 입실한 경우
				if(kd.findPhoneToSeatType(phoneNum) == User.WEEKSEAT && kd.findPhoneToUser(phoneNum).getInTime() == 0) {

					long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
//					User u = kd.findPhoneToUser(phoneNum);
//					u.setInTime(timeNow);
					new AdmDao().admWriteKosk(timeNow, phoneNum);
					client.sendUser(new AdmDao().admRead());
					
					ChangePanel.changePanel(mf, this, new KoskEnterGrp(mf, uList, client,this,light,seattime, phoneNum));
				}else {
					ChangePanel.changePanel(mf, this, new KoskSeatManagement(mf, uList,phoneNum,client,this,light,seattime));
				}
			}else if(kd.login(phoneNumber.getText(), password.getText()) == 2) { // 초기 회원인경우
				ChangePanel.changePanel(mf, this, new KoskSeatTable2(mf,uList, client,phoneNum));
			}
		}
		if(e.getSource() == signUp) {
			ChangePanel.changePanel(mf, this, new KoskSignUp(mf, client));
		}
		if(e.getSource() == findPwd) {
			ChangePanel.changePanel(mf, this, new KoskPsswdFind(mf,client));
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
	
	

