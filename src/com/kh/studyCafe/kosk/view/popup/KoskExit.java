package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskLogin;
import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class KoskExit extends JPanel implements ActionListener {
	private KoskMainFrame mf;
	private JPanel panel;
	private ClientBack client;
	private String phoneNum;
	
	private JButton button;
	
	public KoskExit(KoskMainFrame mf, JPanel panel, String phoneNum, ClientBack client) {
		this.mf = mf;
		this.panel = panel;
		this.phoneNum = phoneNum;
		this.client = client;
		
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color textColor = new Color(127,118,104);
		Color wallPapers = new Color(205, 201, 191);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);
		
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
		
		this.setSize(310,200);
		this.setLocation(25, 180);
		this.setBorder(oneTb);
		this.setBackground(wallPapers);
		this.setLayout(null);
		
		button = new JButton("OK");
		button.setBounds(15,140,280,40);
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);
		button.addActionListener(this);
		
		JLabel label = new JLabel();
		label.setFont(font);
		label.setText("안녕히 가세요");
		label.setBounds(15,60,280,40);
		label.setForeground(textColor);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label1= new JLabel();
		label.setFont(font);
		label1.setText("퇴실이 완료되었습니다");
		label1.setBounds(15,45,280,40);
		label1.setForeground(textColor);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(button);
		this.add(label);
		this.add(label1);
		
		mf.add(this, 0);
		mf.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			KoskDao kd = new KoskDao();
			kd.KoskExitSeat(phoneNum);
			client.sendUser(new AdmDao().admRead());
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
	}
}  