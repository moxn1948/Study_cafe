package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
import com.kh.studyCafe.kosk.view.popup.KoskCheckBoxPop;
import com.kh.studyCafe.kosk.view.popup.KoskPassWordNo;
import com.kh.studyCafe.kosk.view.popup.KoskSignUpCancle;
import com.kh.studyCafe.kosk.view.popup.KoskSignUpPop;

public class KoskSignUp extends JPanel implements ActionListener,ItemListener{

	private KoskMainFrame mf;
	private String nam;
	private String ph;
	private String ps;
	private String pss;
	private JButton cancel;
	private JButton confirm;
	private JTextField nametf;
	private JTextField phtf;
	private JTextField pstf;
	private JTextField psch;
	private JCheckBox check;
	private boolean checkstate = false;
	// 네트워크 코드
	private ClientBack client;

	public KoskSignUp(KoskMainFrame mf, ClientBack client) {
		this.mf = mf;
		// 네트워크 코드
		this.client = client;

		//===== 컬러 설정 =====
		Color wallPapers = new Color(247,244,240);
		Color textColor = new Color(127,118,104);
//		Color paper = new Color(170, 162, 142);
//		Color paper1 = new Color(255,255,255);

		//==================


		//===== JPanel 설정 =======
		this.setLayout(null);
		this.setBackground(wallPapers);
		this.setSize(360,640);

		//============ font 설정 ==========
		Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
		Font inputtext = new Font("맑은 고딕",Font.BOLD,15);
		Font checktext = new Font("맑은 고딕",Font.BOLD,14);
		//===============================

		//====== 로고 이미지아이콘 ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(26, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);
		ib.setBounds(150,0,50,50);
		//===============================

		//=======  제목 설정  ================
		JLabel text = new JLabel("회원가입");
		text.setBounds(120,90,150,50);
		text.setLayout(null);
		text.setFont(siguptext);
		text.setForeground(textColor);
		//===================================

		//========= 라벨 설정 ===================
		JLabel name = new JLabel("이름");
		name.setBounds(36, 198, 40, 30);
		name.setFont(inputtext);
		name.setForeground(textColor);

		JLabel phnumber = new JLabel("휴대폰");
		JLabel phnumber2 = new JLabel("번호");
		phnumber.setBounds(33,246,60,30);
		phnumber2.setBounds(33,263,60,30);
		phnumber.setFont(inputtext);
		phnumber2.setFont(inputtext);
		phnumber.setForeground(textColor);
		phnumber2.setForeground(textColor);

		JLabel psswd = new JLabel("비밀번호");
		psswd.setBounds(33,304,80,30);
		psswd.setForeground(textColor);
		psswd.setFont(inputtext);

		JLabel psswdch = new JLabel("비밀번호");
		JLabel psswdch2 = new JLabel("확인");
		psswdch.setBounds(33, 352,80,30);
		psswdch2.setBounds(33,368,60,30);
		psswdch.setFont(inputtext);
		psswdch2.setFont(inputtext);
		psswdch.setForeground(textColor);
		psswdch2.setForeground(textColor);

		nametf = new JTextField("");
		nametf.setBounds(120,190,200,44);
		nametf.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		phtf = new JTextField("");
		phtf.setBounds(120,244,200,44);
		phtf.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		pstf = new JPasswordField("");
		pstf.setBounds(120,298,200,44);
		pstf.setEditable(true);
		pstf.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		psch = new JPasswordField("");
		psch.setBounds(120,352,200,44);
		psch.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		//===================================


		//====== cancel, confirm 버튼 설정 ========================
		cancel = new JButton("Cancel");
		cancel.setBounds(32,480,141,48);
		cancel.setBackground(new Color(189, 177, 157));
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		cancel.setBorderPainted(false);
		cancel.addActionListener(this);
		
		confirm = new JButton("Confirm");
		confirm.setBounds(179,480,141,48);
		confirm.setBackground(new Color(163, 152, 134));
		confirm.setForeground(Color.WHITE);
		confirm.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		confirm.setBorderPainted(false);
		confirm.addActionListener(this);
		//=================popup버튼 완료 설정==============

		//====== 체크박스 설정 ======================
		check = new JCheckBox(" [필수] 제 3자 이용자 동의 약관");
		check.setBounds(52,430,400,30);
		check.setBackground(wallPapers);
		check.setFont(checktext);
		check.setForeground(textColor);
		check.addItemListener(this);
		//====================================
		this.add(text);
		this.add(ib);
		this.add(name);
		this.add(nametf);
		this.add(phnumber);
		this.add(phnumber2);
		this.add(phtf);
		this.add(psswd);
		this.add(pstf);
		this.add(psswdch);
		this.add(psswdch2);
		this.add(psch);
		this.add(cancel);
		this.add(confirm);
		this.add(check);

		mf.add(this, 0);
		mf.repaint();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
				checkstate = true;
			
		}else if(e.getStateChange() == ItemEvent.DESELECTED){
			checkstate = false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			
		if(e.getSource() == cancel) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		if(e.getSource() == confirm) {
			String num1 = pstf.getText();
			String num2 = psch.getText();
			if(checkstate == true) {
			if(num1.equals(num2)) {
				ArrayList number = new ArrayList();
				number.add(nametf.getText());
				number.add(phtf.getText());
				number.add(pstf.getText());
				number.add(psch.getText());
				
				KoskManager km =  new KoskManager();
				if(km.KoskSgin(number, client) == true) {
					ChangePanel.addPanel(mf, this, new KoskSignUpPop(mf, this, client));
				} else if(km.KoskSgin(number, client) == false){
					ChangePanel.addPanel(mf, this, new KoskPassWordNo(mf, this,client));
				}
			} else {
				ChangePanel.addPanel(mf, this, new KoskPassWordNo(mf, this,client));
			}
			}else {
				ChangePanel.addPanel(mf, this, new KoskCheckBoxPop(mf,this,client));
			}
		}

	}



	
}