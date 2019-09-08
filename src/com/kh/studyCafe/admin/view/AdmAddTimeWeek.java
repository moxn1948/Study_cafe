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

public class AdmAddTimeWeek extends JPanel implements ActionListener {
	//기간권  4번???
	//+,-위치만 수정하면됨
	private ClientBack client;
	private JButton cancelBtn;
	private JButton confirmBtn;
	private JPanel op;
	private AdmMainFrame mf;
	
	public AdmAddTimeWeek(AdmMainFrame mf, JPanel op, String table, ClientBack client) {
		this.client = client;
		this.mf = mf;
		this.op = op;
		
		this.setBounds(300,120,370,452);
		this.setBackground(new Color(239,234,222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
		
		
		JLabel title = new JLabel("기간권");
		title.setLocation(136, 26);
		title.setForeground(new Color(127,118,104));
		title.setFont(new Font("맑은 고딕",Font.BOLD,32));
		title.setSize(title.getPreferredSize());
		
		
		JLabel remainDay = new JLabel("잔여일            일");
		remainDay.setLocation(84, 120);
		remainDay.setForeground(new Color(127,118,104));
		remainDay.setFont(new Font("맑은 고딕",Font.BOLD,22));
		remainDay.setSize(remainDay.getPreferredSize());
		
		
		JLabel dayNum = new JLabel("3");
		dayNum.setLocation(194, 120);
		dayNum.setForeground(new Color(127,118,104));
		dayNum.setFont(new Font("맑은 고딕",Font.BOLD,22));
		dayNum.setSize(dayNum.getPreferredSize());
		
		
		
		
		JLabel afterAdd = new JLabel("연장 후 기간       일");
		afterAdd.setLocation(84, 156);
		afterAdd.setForeground(new Color(127,118,104));
		afterAdd.setFont(new Font("맑은 고딕",Font.BOLD,22));
		afterAdd.setSize(afterAdd.getPreferredSize());
		
		
		JLabel weekNum = new JLabel("14");
		weekNum.setLocation(224, 156);
		weekNum.setForeground(new Color(127,118,104));
		weekNum.setFont(new Font("맑은 고딕",Font.BOLD,22));
		weekNum.setSize(weekNum.getPreferredSize());
		
		
		
		
		
		
		
	
		JLabel showAdd =new JLabel("             일");
//		showAdd.setLocation(200, 252);
		
		showAdd.setOpaque(true);
		showAdd.setBounds(87, 253, 200, 40);
		showAdd.setForeground(new Color(163, 152, 134));
		showAdd.setFont(new Font("맑은 고딕",Font.BOLD,22));
//		showAdd.setSize(showAdd.getPreferredSize());
		showAdd.setBackground(Color.WHITE);
		
		
		JLabel num =new JLabel("7");
//		showAdd.setLocation(200, 252);
		
//		num.setOpaque(false);
//		num.setBounds(87, 253, 200, 40);
		num.setLocation(160, 258);
		num.setForeground(new Color(163, 152, 134));
		num.setFont(new Font("맑은 고딕",Font.BOLD,22));
		num.setSize(num.getPreferredSize());
//		num.setBackground(Color.WHITE);
		
		
		
		
		
		
		
		//+버튼
		JButton plusBtn = new JButton("+");
		plusBtn.setBounds(87, 196, 200, 44);
		plusBtn.setBackground(new Color(127,118,104));
		plusBtn.setFont(new Font("맑은 고딕",Font.BOLD,30));
		plusBtn.setForeground(Color.WHITE);
		
		
		JButton minusBtn = new JButton("-");
		minusBtn.setBounds(87,306, 200, 44);
		minusBtn.setBackground(new Color(127,118,104));
		minusBtn.setFont(new Font("맑은 고딕",Font.BOLD,30));
		minusBtn.setForeground(Color.WHITE);
		
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(20,385,160,50);
		cancelBtn.setBackground(new Color(189, 177, 157));
		cancelBtn.setFont(new Font("맑은 고딕",Font.BOLD,18));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setBorderPainted(false);
		cancelBtn.addActionListener(this);
		

		confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(192,385,160,50);
		confirmBtn.setBackground(new Color(127, 118, 104));
		confirmBtn.setFont(new Font("맑은 고딕",Font.BOLD,18));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setBorderPainted(false);
		confirmBtn.addActionListener(this);
		
		
		//라벨
		this.add(title);
		this.add(remainDay);
		this.add(afterAdd);
		this.add(showAdd);//
		this.add(num,1,0);
		this.add(dayNum);
		this.add(weekNum);
		
		
		
		//버튼
		this.add(plusBtn);
		this.add(minusBtn);
		this.add(cancelBtn);
		this.add(confirmBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {
			String tempClass = AdmMainFrame.watchPanel.getClass().getName().split("view.")[1];
			if(tempClass.equals("AdmUsingUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			if(tempClass.equals("AdmAllUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
		}
		
	}
	

}
