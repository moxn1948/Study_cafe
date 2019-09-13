package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//이미 선택한 좌석
public class AdmUsingSeat extends JPanel implements ActionListener {

	     
	public AdmUsingSeat(AdmMainFrame mf) {
//	    AdmMainFrame.livePanel = this;
	      
		//패널 설정
		      
		this.setBounds(270,203,410,193);
		this.setBackground(new Color(239,234,222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
		
		JLabel title = new JLabel("이미 선택된 좌석입니다.");
		
		title.setLocation(80,43);
		title.setForeground(new Color(127,118,104));
		title.setFont(new Font("맑은 고딕",Font.BOLD,24));
		title.setSize(title.getPreferredSize());
		  
		JButton closeBtn = new JButton("Close");
		
		closeBtn.setBounds(45,120,326,50);
		closeBtn.setBackground(new Color(189, 177, 157));
		closeBtn.setFont(new Font("맑은 고딕",Font.BOLD,18));
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setBorderPainted(false);
	
		
		//패널에 올리기
		this.add(title);
		this.add(closeBtn);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
