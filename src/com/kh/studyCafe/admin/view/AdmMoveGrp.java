package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;

// 스터디룸 이동 불가 안내 팝업
public class AdmMoveGrp extends JPanel implements ActionListener{
	private JPanel op;
	private AdmMainFrame mf;
	private ClientBack client;
	private JButton closeBtn;
	
	public AdmMoveGrp(AdmMainFrame mf, JPanel op, ClientBack client) {
		this.mf = mf;
		this.op = op;
		this.client = client;
		
		//패널 설정
		this.setBounds(270,203,410,193); //오븐
		this.setBackground(new Color(239,234,222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
	
		//title 텍스트 설정
		JLabel title = new JLabel("스터디룸은 이동이 불가능합니다.");
	 
		    
		title.setLocation(29, 43);
		title.setForeground(new Color(127,118,104));
		title.setFont(new Font("맑은 고딕",Font.BOLD,24));
		title.setSize(title.getPreferredSize());
		
		//버튼 설정
		closeBtn = new JButton("Close");
		
		closeBtn.setBounds(45,120,326,50);
		closeBtn.setBackground(new Color(189, 177, 157));
		closeBtn.setFont(new Font("맑은 고딕",Font.BOLD,18));
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setBorderPainted(false);
		closeBtn.addActionListener(this);
		
		//패널에 올리기
		this.add(title);
		this.add(closeBtn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeBtn) {
			String tempClass = AdmMainFrame.watchPanel.getClass().getName().split("view.")[1];
			mf.remove(AdmMainFrame.watchPanel);
			if(tempClass.equals("AdmUsingUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			if(tempClass.equals("AdmAllUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
		}
		
	}
	
}
