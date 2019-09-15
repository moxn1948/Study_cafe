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

public class AdmAddNotice2 extends JPanel implements ActionListener{
	private JPanel op;
	private AdmMainFrame mf;
	private ClientBack client;
	private JButton closeBtn;
	private ControlPanel cp = new ControlPanel();
	
	// 잔여시간 30분 이상일 때, 안내 팝업
	public AdmAddNotice2(AdmMainFrame mf, JPanel op, ClientBack client) {
		this.mf = mf;
		this.op = op;
		this.client = client;
		
		//패널 설정
		this.setBounds(270,250,410,193);
		this.setBackground(new Color(239,234,222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
	
		// 안내문구
		JLabel title = new JLabel("<html><p style='text-align:center;'>잔여일이 100일 미만일 때만<br>연장이 가능합니다.</p></html>");
	 
		title.setLocation(72, 44);
		title.setForeground(new Color(127,118,104));
		title.setFont(new Font("맑은 고딕",Font.BOLD,20));
		title.setSize(title.getPreferredSize());
		
		//버튼 설정
		closeBtn = new JButton("Close");
		
		closeBtn.setBounds(19,124,372,50);
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
				cp.changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			if(tempClass.equals("AdmAllUserList")) {
				cp.changeTablePanel2(mf, op, this, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
		}
	}
	

}
