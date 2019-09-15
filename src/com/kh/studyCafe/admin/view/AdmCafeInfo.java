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
import com.kh.studyCafe.admin.model.vo.AdmCafe;
import com.kh.studyCafe.client.ClientBack;

public class AdmCafeInfo extends JPanel implements ActionListener {
	
	private JPanel op = null;
	private AdmMainFrame mf;
	private ClientBack client;
	private JButton closeBtn;
	
	private AdmDao ad = new AdmDao();
	
	public AdmCafeInfo(AdmMainFrame mf,JPanel op, ClientBack client) {
		this.mf=mf;
		this.op=op;
		this.client=client;
		
		
		this.setBounds(270, 120, 391, 390);
		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		
		
		//title 텍스트 설정
		JLabel title = new JLabel("매장 정보");
		
		title.setLocation(130, 30);
		title.setForeground(new Color(127, 118, 104));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		title.setSize(title.getPreferredSize());
		
		// subTitle 텍스트 설정
		JLabel subTitle = new JLabel("총 매출");

		subTitle.setLocation(60, 104);
		subTitle.setForeground(new Color(127, 118, 104));
		subTitle.setFont(new Font("맑은 고딕",Font.BOLD,22));
		subTitle.setSize(subTitle.getPreferredSize());
		
		JLabel subTitle2 = new JLabel("총 회원수");
		subTitle2.setLocation(60, 230);
		subTitle2.setForeground(new Color(127, 118, 104));
		subTitle2.setFont(new Font("맑은 고딕",Font.BOLD,22));
		subTitle2.setSize(subTitle2.getPreferredSize());
		
		JLabel pNumPut = new JLabel(ad.readCafe().getTotalUserAmount()+"명");
		pNumPut.setLocation(200, 230);
		pNumPut.setForeground(new Color(127, 118, 104));
		pNumPut.setFont(new Font("맑은 고딕",Font.BOLD,22));
		pNumPut.setSize(pNumPut.getPreferredSize());
		
		JLabel day = new JLabel("Day");
		day.setLocation(200, 102);
		day.setForeground(new Color(127, 118, 104));
		day.setFont(new Font("맑은 고딕",Font.BOLD,22));
		day.setSize(day.getPreferredSize());
		
		JLabel month = new JLabel("Month");
		month.setLocation(200, 164);
		month.setForeground(new Color(127, 118, 104));
		month.setFont(new Font("맑은 고딕",Font.BOLD,22));
		month.setSize(month.getPreferredSize());
		
		JLabel wonPut = new JLabel(ad.readCafe().getTotalDaySales()+"원");
		wonPut.setLocation(200, 132);
		wonPut.setForeground(new Color(127, 118, 104));
		wonPut.setFont(new Font("맑은 고딕",Font.BOLD,22));
		wonPut.setSize(wonPut.getPreferredSize());
		
		JLabel won2Put = new JLabel(ad.readCafe().getTotalMonthSales()+"원");
		won2Put.setLocation(200, 192);
		won2Put.setForeground(new Color(127, 118, 104));
		won2Put.setFont(new Font("맑은 고딕",Font.BOLD,22));
		won2Put.setSize(won2Put.getPreferredSize());
		
		
		// 버튼 설정
		closeBtn = new JButton("Close");
		closeBtn.setBounds(33, 306, 326, 50);
		closeBtn.setBackground(new Color(163, 152, 134));
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		closeBtn.setBorderPainted(false);
		closeBtn.addActionListener(this);
		
		this.add(title);
		this.add(subTitle);
		this.add(subTitle2); //총회원수 타이틀
		this.add(pNumPut);//명
		
	    this.add(closeBtn);
	    this.add(day);
	    this.add(month);
	    this.add(wonPut);
	    this.add(won2Put);
	    
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeBtn) {
			mf.remove(AdmMainFrame.watchPanel);
			new ControlPanel().changeTablePanel2(mf, this, op, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), ad.admRead(), client));				
		}
	}

}
