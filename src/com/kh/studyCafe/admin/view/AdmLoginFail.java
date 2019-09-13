package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.client.ClientBack;

public class AdmLoginFail extends JPanel implements ActionListener {

//	private JPanel login= new JPanel();
	private JPanel op =null;
	private AdmMainFrame mf;
	private ClientBack client;
	private JButton closeBtn;
	
	
	public AdmLoginFail(AdmMainFrame mf , JPanel op, ClientBack client) {
		this.mf=mf;
		this.op=op;
		this.client=client;

//		AdmMainFrame.livePanel = this;
		
		//패널 설정
		this.setBounds(270, 203, 450, 193);
		this.setBackground(new Color(239,234,193));
		this.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
	
		
		//title텍스트 설정
		JLabel logFail= new JLabel("아이디 비밀번호를 다시 확인해 주세요.");
		
		logFail.setBounds(12, 30, 430, 70);
		logFail.setForeground(new Color(127,118,104));
		logFail.setFont(new Font("맑은 고딕",Font.BOLD,24));
		
		
		
		//close 버튼
		closeBtn = new JButton("Close");
		
		closeBtn.setBounds(60, 120, 326, 50);
		closeBtn.setBackground(new Color(189,177,157));
		closeBtn.setFont(new Font("맑은 고딕",Font.BOLD,18));
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setBorderPainted(false);
		closeBtn.addActionListener(this);
		
		//패널에 올리기
		this.add(logFail);
		this.add(closeBtn);
		
		//체인지 패널
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ControlPanel cp = new ControlPanel();
		
		if(e.getSource()==closeBtn) {
			mf.remove(this);
			
			for(Component cp2 : op.getComponents()) {
				cp2.setEnabled(true);
			}
			
			
			
		}
		
	}

}
