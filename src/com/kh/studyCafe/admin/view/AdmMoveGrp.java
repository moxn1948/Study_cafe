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

public class AdmMoveGrp extends JPanel implements ActionListener{
//자리이동 팝업 2번
//이거하나됨...	
	private JPanel op = null;
	private AdmMainFrame mf;
	private ClientBack client;
	
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
		
		/*//subTitle텍스트 설정
		JLabel subTitle = new JLabel("스터디룸은 이동이 불가능합니다.");
		//340,75
		  
		subTitle.setLocation(120, 104);
		subTitle.setForeground(new Color(127,118,104));//색같은데.
		subTitle.setFont(new Font("맑은 고딕",Font.BOLD,24));
		subTitle.setSize(subTitle.getPreferredSize());
		*/
		//버튼 설정
		JButton closeBtn = new JButton("Close");
		
		//close버
		
//		closeBtn.setLocation(600,543); 이건 걍 해본거..
		closeBtn.setBounds(45,120,326,50);
		
		closeBtn.setBackground(new Color(189, 177, 157)); //컬러
		
		closeBtn.setFont(new Font("맑은 고딕",Font.BOLD,18)); 	 //볼드??
		
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setBorderPainted(false);
		
		closeBtn.addActionListener(this);
		
		//패널에 올리기
		this.add(title);
//		this.add(subTitle);
		this.add(closeBtn);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));

	}
	
	
	
	
	//자리이동
	//스터디룸 이동 불가팝업

}
