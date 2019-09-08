package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;

public class AdmAddTimeHour extends JPanel implements ActionListener {
	
	
	private AdmMainFrame mf;
	private int term = 1;
	private JLabel num = null;
	private JButton plusBtn = null;
	private JButton minusBtn = null;
	private JButton confirmBtn = null;
	private String phoneNum;
	private String name;
	private JPanel op = null;
	private ClientBack client;
	
	public AdmAddTimeHour(AdmMainFrame mf, JPanel op, String phoneNum, ClientBack client) {
		this.mf = mf;
		this.op = op;
		this.phoneNum = phoneNum;
		this.client = client;
		
		//name = new AdmManager().findPhoneToName(phoneNum);

//		System.out.println(new AdmManager().findPhoneToRemain(phoneNum));
		Date remainEdit = new Date(new AdmManager().findPhoneToRemain(phoneNum));
		SimpleDateFormat sdf = new SimpleDateFormat("hh : mmaa");
		String timeEdit = sdf.format(remainEdit).split("오")[0];
		// System.out.println(timeEdit);

		this.setLayout(null);
		this.setBounds(300, 120, 370, 452);
		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		// title 설정

		JLabel title = new JLabel("1일권");
		title.setLocation(146, 26);
		title.setForeground(new Color(127, 118, 104));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		title.setSize(title.getPreferredSize());

		JLabel remainTime = new JLabel("잔여시간");

		remainTime.setLocation(90, 100);
		remainTime.setForeground(new Color(127, 118, 104));
		remainTime.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		remainTime.setSize(remainTime.getPreferredSize());

		JLabel remainNum = new JLabel(timeEdit); // 잔여시간
		remainNum.setLocation(224, 98);
		remainNum.setForeground(new Color(127, 118, 104));
		remainNum.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		remainNum.setSize(remainNum.getPreferredSize());

		JLabel afterTime = new JLabel("연장 후 시간");
		afterTime.setLocation(90, 143);
		afterTime.setForeground(new Color(127, 118, 104));
		afterTime.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		afterTime.setSize(afterTime.getPreferredSize());

		JLabel afterNum = new JLabel("03:30");
		afterNum.setLocation(224, 141);
		afterNum.setForeground(new Color(127, 118, 104));
		afterNum.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		afterNum.setSize(afterNum.getPreferredSize());

		plusBtn = new JButton("+");
		plusBtn.setBounds(87, 196, 200, 44);
		plusBtn.setBackground(new Color(127, 118, 104));
		plusBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		plusBtn.setForeground(Color.WHITE);
		plusBtn.addActionListener(this);

		// +-사이 값 유동
		JLabel showAdd = new JLabel("       ");

		showAdd.setOpaque(true);
		showAdd.setBounds(87, 253, 200, 40);
		showAdd.setForeground(new Color(163, 152, 134));
		showAdd.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		showAdd.setBackground(Color.WHITE);

		num = new JLabel("0" + term + " : 00"); // 숫자 수정
		num.setLocation(158, 258);
		num.setForeground(new Color(163, 152, 134));
		num.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		num.setSize(num.getPreferredSize());

		minusBtn = new JButton("-");
		minusBtn.setBounds(87, 306, 200, 44);
		minusBtn.setBackground(new Color(127, 118, 104));
		minusBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		minusBtn.setForeground(Color.WHITE);
		minusBtn.addActionListener(this);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(20, 385, 160, 50);
		cancelBtn.setBackground(new Color(189, 177, 157));
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setBorderPainted(false);

		confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(192, 385, 160, 50);
		confirmBtn.setBackground(new Color(127, 118, 104));
		confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setBorderPainted(false);
		confirmBtn.addActionListener(this);

		this.add(title);
		this.add(remainTime);
		this.add(afterTime);
		this.add(showAdd);
		this.add(num, 0, 1);
		this.add(remainNum);
		this.add(afterNum);

		// 버튼
		this.add(plusBtn);
		this.add(minusBtn);
		this.add(cancelBtn);
		this.add(confirmBtn);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == plusBtn) {
			if (term < 9 && term > 0) {
				++term;

				System.out.println("a  : " + term);
				num.setText("0" + term + " : 00");
			} else if (term < 23 && term > 8) {
				++term;

				System.out.println("b  : " + term);
				num.setText(term + " : 00");
			}
		}

		if (e.getSource() == minusBtn) {
			if (term < 9 && term > 1) {

				--term;
				System.out.println("c  : " + term);
				num.setText("0" + term + " : 00");
			} else if (term < 24 && term > 8) {

				--term;
				System.out.println("d  : " + term);
				num.setText(term + " : 00");
			}
		}

		if (e.getSource() == confirmBtn) {
//			System.out.println("여긴가..?");
			
			// 본인 클라이언트 스트림으로 보냄
			System.out.println("b");
			AdmManager ad = new AdmManager();
			client.sendUser(ad.addRemainTime(phoneNum, term));
			
			mf.remove(this);
			//new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));
		}

	}

}
