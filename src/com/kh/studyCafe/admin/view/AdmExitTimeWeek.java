package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.service.AdmUserInfoChk;
import com.kh.studyCafe.client.ClientBack;

public class AdmExitTimeWeek extends JPanel implements ActionListener{
	private JPanel op = null;
	private ClientBack client;
	private AdmMainFrame mf;
	private JButton cancelBtn;
	private JButton confirmBtn;
	private String phoneNum;
	private JCheckBox refundChk;
	boolean refundChked;
	
	public AdmExitTimeWeek(AdmMainFrame mf, JPanel op, ClientBack client, String phoneNum) {
		this.op = op;
		this.client = client;
		this.mf = mf;
		this.phoneNum = phoneNum;
//		AdmMainFrame.livePanel = this;
	
		
		// 패널 설정
		int w = 410;
		int h = 274;
		int x = popPosition(w, h)[0];
		int y = popPosition(w, h)[1];
		
		this.setBounds(x, y, w, h); 
		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		
		// title 텍스트 설정
		JLabel title = new JLabel("기간권 퇴실");

		title.setLocation(120, 32);
		title.setForeground(new Color(127, 118, 104));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		title.setSize(title.getPreferredSize());
		
		// subTitle 텍스트 설정
		JLabel subTitle = new JLabel("잔여시간");

		subTitle.setLocation(120, 104);
		subTitle.setForeground(new Color(127, 118, 104));
		subTitle.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		subTitle.setSize(subTitle.getPreferredSize());
		
		// 잔여시간 텍스트 설정
		long remainTimeNum = new AdmUserInfoChk().toRemainInfo(phoneNum, new AdmDao().admRead());
		String remainTimeStr = (remainTimeNum - 1) / 86400000 + 1 + "일"; 
		
		JLabel remainTime = new JLabel(remainTimeStr); // 나중에 데이터 받아서 값 올려야함

		remainTime.setLocation(237, 104);
		remainTime.setForeground(new Color(127, 118, 104));
		remainTime.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		remainTime.setSize(remainTime.getPreferredSize());
		
		// 환불 체크박스 설정
		refundChk = new JCheckBox("환불하시겠습니까?");
		refundChk.setLocation(17, 168);
		refundChk.setOpaque(false);
		refundChk.setForeground(new Color(127, 118, 104));
		refundChk.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		refundChk.setSize(refundChk.getPreferredSize());
		refundChk.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					refundChked = true;
				}
				
			}
		});
		
		// 버튼 설정
		cancelBtn = new JButton("Cancel");
		confirmBtn = new JButton("Confirm");
		
		cancelBtn.setBounds(16, 209, 184, 50);
		confirmBtn.setBounds(210, 209, 184, 50);
		cancelBtn.setBackground(new Color(189, 177, 157));
		confirmBtn.setBackground(new Color(163, 152, 134));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		cancelBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		confirmBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		cancelBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
		
		
		// 패널에 올리기
		this.add(title);
		this.add(subTitle);
		this.add(remainTime);
		this.add(refundChk);
		this.add(cancelBtn);
		this.add(confirmBtn);
	}

	public int[] popPosition(int w, int h) {
		int[] position = new int[2];
		
		position[0] = (962 - w) / 2;
		position[1] = (662 - h) / 2;
		
		return position;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AdmManager ad = new AdmManager();
		if(e.getSource() == cancelBtn) {
			String tempClass = AdmMainFrame.watchPanel.getClass().getName().split("view.")[1];
			if(tempClass.equals("AdmUsingUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			if(tempClass.equals("AdmAllUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}		
		}
		if(e.getSource() == confirmBtn) {
			if(refundChked == true) {
				
				client.sendUser(ad.refundSeatWeek(phoneNum));
				mf.remove(this);
			}else {
				client.sendUser(ad.exitSeatWeek(phoneNum));
			    mf.remove(this);
			}
		}
		
	}

}
