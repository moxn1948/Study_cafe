package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.model.vo.User;

public class KoskCashButton extends JPanel implements ActionListener{
	private KoskMainFrame mf;
	private JPanel panel;
	private ArrayList<User> uList;
	private String seatnum;
	private long seattime;
	private String phnum;
	private int hOfw;
	private ClientBack client;
	
	private JButton button;
	
	public KoskCashButton(KoskMainFrame mf, JPanel panel, ArrayList<User> uList, String seatnum, long seattime, String phnum, int hOfw, ClientBack client) {
		this.mf = mf;
		this.panel = panel;
		this.uList = uList;
		this.seatnum = seatnum;
		this.seattime = seattime;
		this.phnum = phnum;
		this.hOfw = hOfw;
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
		
		 
		button = new JButton("현금을 넣어주세요");
		button.setBounds(10,15,300,100);
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);
		button.addActionListener(this);
		
		this.add(button);
		
		mf.add(this, 0);
		mf.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			KoskDao kd = new KoskDao();
			kd.Kosktimeplus2(uList,seatnum,seattime,phnum,hOfw, client);
			client.sendUser(new AdmDao().admRead());
			ChangePanel.changePanel(mf, this, new KoskPaySuccess(mf, this, client));
		}
	}
}