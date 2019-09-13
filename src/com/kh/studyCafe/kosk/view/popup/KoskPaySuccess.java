package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskLogin;
import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class KoskPaySuccess extends JPanel implements ActionListener{
	private KoskMainFrame mf;
	private JPanel panel;
	private ClientBack client;
	private JButton button;
	
	public KoskPaySuccess(KoskMainFrame mf, JPanel panel, ClientBack client) {
		this.mf = mf;
		this.panel = panel;
		this.client = client;
		
		KoskMainFrame.koskWatchPanel = this;
		
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color textColor = new Color(127,118,104);
		Color wallPapers = new Color(205, 201, 191);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);

		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
		
		this.setSize(320,130);
		this.setLocation(25, 195);
		this.setBorder(oneTb);
		this.setBackground(wallPapers);
		this.setLayout(null);
		 
		button = new JButton("결제가 완료되었습니다.");
		button.setBounds(10,15,300,100);
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);
		button.addActionListener(this);
		
		this.add(button);
		mf.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		
	}
}