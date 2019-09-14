package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.model.vo.User;

public class KoskEnterGrp extends JPanel implements ActionListener{
	
	private KoskMainFrame mf;
	private ArrayList<User> uList;
	private ClientBack client;
	private JPanel op;
	private String light;
	private long seattime;
	private String phoneNum;
	
	private JButton cancelBtn;
	private JButton confirmBtn;
	
	public KoskEnterGrp(KoskMainFrame mf, ArrayList<User> uList, ClientBack client, JPanel op, String light, long seattime, String phoneNum) {
		this.mf = mf;
		this.uList = uList;
		this.client = client;
		this.op = op;
		this.light = light;
		this.seattime = seattime;
		this.phoneNum = phoneNum;

		this.setLayout(null);
		this.setBackground(new Color(239,234,222));
		this.setSize(360,640);

		JLabel ment = new JLabel("<html><p style='text-align: center;'>입실 되었습니다.<br>정보를 수정하시겠습니까?</p></html>");
		ment.setLocation(46, 240);
		ment.setForeground(new Color(127, 118, 104));
		ment.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		ment.setSize(ment.getPreferredSize());

		// 로고 설정
		Image icon = new ImageIcon("img/logo.png").getImage().getScaledInstance(26, 34, 0);
		JLabel logoIcon = new JLabel(new ImageIcon(icon));
		logoIcon.setLocation(165, 190);
		logoIcon.setSize(26, 34);
		
		// 버튼 설정
		cancelBtn = new JButton("Cancel");
		confirmBtn = new JButton("Confirm");

		cancelBtn.setBounds(12, 320, 160, 50);
		confirmBtn.setBounds(182, 320, 160, 50);
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

		
		this.add(ment);
		this.add(logoIcon);
		this.add(cancelBtn);
		this.add(confirmBtn);
		
		/*
		 * 
			KoskDao kd = new KoskDao();
			String phoneNum = phoneNumber.getText();
			ArrayList<User> uList;
			uList = kd.uList();
			String light = (uList.get(kd.userindex(phoneNum)).getSeatNum());
			long seattime = uList.get(kd.userindex(phoneNum)).getRemainTime();
			
			if(kd.login(phoneNumber.getText(), password.getText()) == 1) { // 이미 입실한 경우
				 ChangePanel.changePanel(mf, this, new KoskSeatManagement(mf, uList,phoneNum,client,this,light,seattime));
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		
		if(e.getSource() == confirmBtn) {

			System.out.println("enter phone : "+phoneNum);
			 ChangePanel.changePanel(mf, this, new KoskSeatManagement(mf, uList,phoneNum,client,this,light,seattime));
		}
	}
	
	
}
