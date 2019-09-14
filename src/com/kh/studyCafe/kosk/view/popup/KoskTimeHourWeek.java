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
import com.kh.studyCafe.kosk.model.dao.KoskDao;
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
	 private String seatnum;
	 private String phnum;
	 private int tableOrManage;
	public  KoskTimeHourWeek(KoskMainFrame mf, ArrayList<User> uList,String phnum, ClientBack client,JPanel panel, String seatnum,int tableOrManage) {
		KoskDao kd = new KoskDao();
		this.panel = panel;
		this.mf = mf;
		this.uList = uList;
		this.client = client;
		this.seatnum = seatnum;
		this.phnum = phnum;
		this.tableOrManage = tableOrManage;
		
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
		this.setOpaque(true);
		
		this.add(oneday);
		this.add(Period);
		mf.repaint();
		String str = uList.get(kd.userindex(phnum)).getSeatNum()+"aa";
		
		if(str.substring(1,2).equals("-")) {
			Period.setVisible(false);
			oneday.setSize(220,68);
		} 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == oneday) {
			if(uList.get(0).getRemainTime() <= 1800000L) {
				ChangePanel.changePanel(mf, this,new KoskIndividualPanel(mf,uList,phnum,client,panel,seatnum,1,tableOrManage));
			}else {
				oneday.setVisible(false);
				ChangePanel.addPanel(mf, this, new RemainTimePopup(mf, this, client));
			}
		}
		if(e.getSource() == Period) {
			ChangePanel.changePanel(mf, this,new KoskIndividualPanel2(mf,uList,phnum,client,panel,seatnum,2,tableOrManage));
		}
	}

}
