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
	
	private ClientBack client;
	private int term = 7;
	private JButton cancelBtn;
	private JButton confirmBtn;
	private JPanel op;
	private String phoneNum;
	private AdmMainFrame mf;
	private JLabel num;
	private JButton plusBtn;
	private JButton minusBtn;
	private String addTimeEdit;
	private JLabel weekNum;
	
	private AdmManager ad = new AdmManager();
	private ControlPanel cp = new ControlPanel();
	
	public AdmAddTimeWeek(AdmMainFrame mf, JPanel op, String phoneNum, ClientBack client) {
		this.client = client;
		this.mf = mf;
		this.op = op;
		this.phoneNum = phoneNum;

		// 잔여시간 표시
		String timeEdit = new AdmManager().findPhoneToRemain(phoneNum) / 86400000 + 1 + "";
		addTimeEdit = new AdmManager().findPhoneToRemain(phoneNum) / 86400000 + 8 + "";
		
		this.setLayout(null);
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
		
		JLabel dayNum = new JLabel(timeEdit); // 잔여일 표시
		dayNum.setLocation(194, 120);
		dayNum.setForeground(new Color(127,118,104));
		dayNum.setFont(new Font("맑은 고딕",Font.BOLD,22));
		dayNum.setSize(dayNum.getPreferredSize());
		
		JLabel afterAdd = new JLabel("연장 후 기간       일");
		afterAdd.setLocation(84, 156);
		afterAdd.setForeground(new Color(127,118,104));
		afterAdd.setFont(new Font("맑은 고딕",Font.BOLD,22));
		afterAdd.setSize(afterAdd.getPreferredSize());
		
		weekNum = new JLabel(addTimeEdit); // 연장 후 기간
		weekNum.setLocation(224, 156);
		weekNum.setForeground(new Color(127,118,104));
		weekNum.setFont(new Font("맑은 고딕",Font.BOLD,22));
		weekNum.setSize(weekNum.getPreferredSize());
		
		JLabel showAdd =new JLabel("             일");
		
		showAdd.setOpaque(true);
		showAdd.setBounds(87, 253, 200, 40);
		showAdd.setForeground(new Color(163, 152, 134));
		showAdd.setFont(new Font("맑은 고딕",Font.BOLD,22));
		showAdd.setBackground(Color.WHITE);
		
		num =new JLabel(term + "");
		
		num.setLocation(160, 258);
		num.setForeground(new Color(163, 152, 134));
		num.setFont(new Font("맑은 고딕",Font.BOLD,22));
		num.setSize(num.getPreferredSize());
		
		//+버튼
		plusBtn = new JButton("+");
		plusBtn.setBounds(87, 196, 200, 44);
		plusBtn.setBackground(new Color(127,118,104));
		plusBtn.setFont(new Font("맑은 고딕",Font.BOLD,30));
		plusBtn.setForeground(Color.WHITE);
		plusBtn.addActionListener(this);
		
		minusBtn = new JButton("-");
		minusBtn.setBounds(87,306, 200, 44);
		minusBtn.setBackground(new Color(127,118,104));
		minusBtn.setFont(new Font("맑은 고딕",Font.BOLD,30));
		minusBtn.setForeground(Color.WHITE);
		minusBtn.addActionListener(this);
		
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
		
		this.add(title);
		this.add(remainDay);
		this.add(afterAdd);
		this.add(showAdd);
		this.add(num,1,0);
		this.add(dayNum);
		this.add(weekNum);
		this.add(plusBtn);
		this.add(minusBtn);
		this.add(cancelBtn);
		this.add(confirmBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == plusBtn) {
			if (term < 28) {
				
				String[] addTimeEditTemp = addTimeEdit.split("일");
				if(Integer.parseInt(addTimeEditTemp[0]) + 7 < 100 && Integer.parseInt(addTimeEdit) < 100) {
					term += 7;
					
					num.setText(term + "");	
					addTimeEditTemp[0] = Integer.parseInt(addTimeEditTemp[0]) + 7 + "";
					addTimeEdit = addTimeEditTemp[0];  
					weekNum.setText(addTimeEdit);
					weekNum.setSize(weekNum.getPreferredSize());
					num.setSize(num.getPreferredSize());
					
				}
				
			} 
		}

		if (e.getSource() == minusBtn) {
			if (term > 7) {
				term -= 7;
				
				num.setText(term + "");	
				String[] addTimeEditTemp = addTimeEdit.split("일");
				addTimeEditTemp[0] = Integer.parseInt(addTimeEditTemp[0]) - 7 + "";
				addTimeEdit = addTimeEditTemp[0];  
				weekNum.setText(addTimeEdit);
				weekNum.setSize(weekNum.getPreferredSize());
				num.setSize(num.getPreferredSize());
				
			} 
		}
		
		if(e.getSource() == cancelBtn) {
			String tempClass = AdmMainFrame.watchPanel.getClass().getName().split("view.")[1];
			mf.remove(AdmMainFrame.watchPanel);
			if(tempClass.equals("AdmUsingUserList")) {
				cp.changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			if(tempClass.equals("AdmAllUserList")) {
				cp.changeTablePanel2(mf, op, this, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
		}
		
		if (e.getSource() == confirmBtn) {
			mf.remove(this);
			client.sendUser(ad.addWeekRemainTime(phoneNum, term));
			
		}
		
	}

}
