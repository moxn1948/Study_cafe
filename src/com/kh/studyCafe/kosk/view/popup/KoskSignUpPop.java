package com.kh.studyCafe.kosk.view.popup;


import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskLogin;
import com.kh.studyCafe.kosk.view.KoskMainFrame;


public class KoskSignUpPop extends JPanel implements ActionListener{
	private KoskMainFrame mf;
	private JPanel panel;	
	private ClientBack client;
	
	private JButton button;
	
	public KoskSignUpPop(KoskMainFrame mf, JPanel panel, ClientBack client) {
		this.mf = mf;
		this.panel = panel;
		this.client = client;
	
		Font font = new Font("맑은 고딕",Font.BOLD,16);
		Color wallPapers = new Color(239, 234, 222);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);
		
		this.setSize(300, 180);
		this.setLocation(26, 208);
		this.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));
		this.setBackground(wallPapers);
		this.setLayout(null);
		
		button = new JButton("OK");
		button.setBounds(10,130,280,40);
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);
		button.addActionListener(this);
		
		JLabel label = new JLabel("회원 가입이 완료되었습니다");
		label.setFont(font);
		label.setBounds(10,64,280,26);
		label.setHorizontalAlignment(JLabel.CENTER);
		  
		this.add(button);
		this.add(label);
		
		mf.add(this, 0);
		mf.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		
	}

}   