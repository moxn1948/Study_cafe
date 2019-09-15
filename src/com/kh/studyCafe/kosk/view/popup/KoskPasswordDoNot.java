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
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.kosk.view.KoskPsswdFind;

public class KoskPasswordDoNot extends JPanel  implements ActionListener{
	private KoskMainFrame mf;
	private ClientBack client;
	private JPanel panel;
	private String phoneNum;
	private JButton button;
	
	public KoskPasswordDoNot(KoskMainFrame mf, JPanel panel, String phoneNum, ClientBack client) {
		this.mf = mf;
		this.client = client;
		this.phoneNum = phoneNum;
		this.panel = panel;
		
		Font font = new Font("맑은 고딕",Font.BOLD,16);
		Color wallPapers = new Color(239, 234, 222);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);

		this.setSize(300, 180);
		this.setLocation(26, 188);
		this.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));
		this.setBackground(wallPapers);
		this.setLayout(null);
	
		button = new JButton("OK");
		button.setBounds(10,130,280,40);
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);
		button.addActionListener(this);

		JLabel label1= new JLabel();
		label1.setText("이름 혹은 전화번호를");
		label1.setFont(font);
		label1.setBounds(10,44,280,40);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label = new JLabel();
		label.setFont(font);
		label.setText("잘못 입력하였습니다");
		label.setBounds(10,64,280,40);
		label.setHorizontalAlignment(JLabel.CENTER);
	     
	
		this.add(button);
		this.add(label);
		this.add(label1);
		
		mf.add(this, 0);
		mf.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			ChangePanel.popchangePanel(mf, this, new KoskPsswdFind(mf, client));
		}
		
	}

}   