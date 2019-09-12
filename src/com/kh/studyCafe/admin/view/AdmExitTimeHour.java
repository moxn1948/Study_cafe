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

public class AdmExitTimeHour extends JPanel implements ActionListener{
	private JPanel op = null;
	private JButton cancelBtn;
	private JButton confirmBtn;
	private AdmMainFrame mf;
	private ClientBack client;
	private String phoneNum;

	public AdmExitTimeHour(AdmMainFrame mf, JPanel op, ClientBack client, String phoneNum) {
		this.op = op;
		this.mf = mf;
		this.client = client;
		this.phoneNum = phoneNum;
		String timeEdit = "";

		if(new AdmManager().findPhoneToRemain(phoneNum) % 3600000 / 60000 + 1 == 60) {
			timeEdit += new AdmManager().findPhoneToRemain(phoneNum) / 3600000 + 1 + "시간 ";
			timeEdit += "0분";
		}else {	
			timeEdit += new AdmManager().findPhoneToRemain(phoneNum) / 3600000 + "시간 ";
			timeEdit += new AdmManager().findPhoneToRemain(phoneNum) % 3600000 / 60000 + 1 + "분";
		}

		// 패널 설정
		int w = 410;
		int h = 250;
		int x = popPosition(w, h)[0];
		int y = popPosition(w, h)[1];

		this.setBounds(x, y, w, h); 	
		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		// title 텍스트 설정
		JLabel title = new JLabel("1일권 퇴실");

		title.setLocation(124, 34);
		title.setForeground(new Color(127, 118, 104));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		title.setSize(title.getPreferredSize());

		// subTitle 텍스트 설정
		JLabel subTitle = new JLabel("잔여시간");

		subTitle.setLocation(106, 104);
		subTitle.setForeground(new Color(127, 118, 104));
		subTitle.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		subTitle.setSize(subTitle.getPreferredSize());

		// 잔여시간 텍스트 설정
		JLabel remainTime = new JLabel(timeEdit); // 나중에 데이터 받아서 값 올려야함

		remainTime.setLocation(230, 104);
		remainTime.setForeground(new Color(127, 118, 104));
		remainTime.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		remainTime.setSize(remainTime.getPreferredSize());

		// 버튼 설정
		cancelBtn = new JButton("Cancel");
		confirmBtn = new JButton("Confirm");

		cancelBtn.setBounds(16, 183, 184, 50);
		confirmBtn.setBounds(210, 183, 184, 50);
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

			AdmManager ad = new AdmManager(); 
			client.sendUser(ad.exitSeatTime(phoneNum));
			mf.remove(this);


		}

	}

}
