package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.model.vo.User;

public class KoskTimeHourWeek extends JPanel implements ActionListener{
	 private KoskMainFrame mf ;
	 private JPanel panel;
	 private JButton oneday;
	 private JButton Period;
	 private ArrayList<User> uList;
	 private ClientBack client;
	 private int light;
	 private String phnum;
	public  KoskTimeHourWeek(KoskMainFrame mf, ArrayList<User> uList,String phnum, ClientBack client,JPanel panel, int light) {
		this.panel = panel;
		this.mf = mf;
		this.uList = uList;
		this.client = client;
		this.light = light;
		this.phnum = phnum;
		
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
		Color paper = new Color(163, 152, 134);
		Color paper1 = new Color(255,255,255);
		
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
 	 
		this.setSize(310,250);
		this.setLocation(25, 195);
		this.setBorder(oneTb);
		this.setBackground(wallPapers);
		this.setLayout(null);
		
	    oneday = new JButton("1일권");
	    oneday.addActionListener(this);
		oneday.setFont(font);
		oneday.setBounds(50,70,100,68); 
		oneday.setBackground(paper);
		oneday.setForeground(paper1);
		
		Period = new JButton("기간권");
		Period.addActionListener(this);
		Period.setFont(font);
		Period.setBounds(160,70,100,68);
		Period.setBackground(paper);
		Period.setForeground(paper1);
		
		JLabel label = new JLabel();
		label.setForeground(textColor);
		panel.setOpaque(true);
		
		this.add(oneday);
		this.add(Period);
		mf.repaint();
		
	
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == oneday) {
			ChangePanel.changePanel(mf, this,new KoskIndividualPanel(mf,uList,phnum,client,panel,light));
		}
		if(e.getSource() == Period) {
			
		}
	}

}
