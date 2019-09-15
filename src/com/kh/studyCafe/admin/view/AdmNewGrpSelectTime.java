package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;

public class AdmNewGrpSelectTime extends JPanel implements ActionListener{
	private AdmMainFrame mf;
	private JPanel op;
	private ClientBack client;
	private String phoneNum;
	private JButton cancelBtn;
	private JButton confirmBtn;
	private int term = 1;
	private JButton countUpBtn;
	private JButton countDownBtn;
	private ArrayList<AdmUserTable> utList;
	private ArrayList<User> u;
	private JPanel op2;
	private String selectSeat;
	private JLabel totalUserCountNum;
	private JLabel totalUserTimeNum;
	private JButton timeUpBtn;
	private JButton timeDownBtn;
	private JLabel countDisplay;
	private JLabel timeDisplay;
	private int count;
	private int minNum;
	private int maxNum;
	
	private ControlPanel cp = new ControlPanel();
	private AdmManager ad = new AdmManager();

	public AdmNewGrpSelectTime(AdmMainFrame mf, JPanel op,JPanel op2, ClientBack client, String phoneNum, ArrayList<AdmUserTable> utList, ArrayList<User> u, String selectSeat) {
		this.mf = mf;
		this.op = op;
		this.op2 = op2;
		this.client = client;
		this.phoneNum = phoneNum;
		this.utList = utList;
		this.u = u;
		this.selectSeat = selectSeat;
		
		String grp = selectSeat.split("-")[0];
		if(grp.equals("4")){
			count = 2;
			minNum = 2;
			maxNum = 4;
		}else if(grp.equals("6")){
			count = 4;
			minNum = 4;
			maxNum = 6;
		}else {
			count = 6;
			minNum = 6;
			maxNum = 8;
		}	

		// 패널 설정
		int w = 540;
		int h = 467;
		int x = popPosition(w, h)[0];
		int y = popPosition(w, h)[1];

		this.setLayout(null);
		this.setBounds(x, y, w, h); 
		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		// title 텍스트 설정
		JLabel title = new JLabel("1일권");
		title.setLocation(230, 34);
		title.setForeground(new Color(127, 118, 104));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		title.setSize(title.getPreferredSize());

		// 인원 텍스트 설정
		JLabel userCount = new JLabel("인원");
		userCount.setLocation(114, 104);
		userCount.setForeground(new Color(127, 118, 104));
		userCount.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		userCount.setSize(userCount.getPreferredSize());

		// 총 인원 표시
		JLabel totalUserCount = new JLabel("총 인원");
		totalUserCount.setLocation(90, 170);
		totalUserCount.setForeground(new Color(127, 118, 104));
		totalUserCount.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalUserCount.setSize(totalUserCount.getPreferredSize());

		// 총 인원 - 명수 표시
		totalUserCountNum = new JLabel(count + "명");
		totalUserCountNum.setLocation(164, 170);
		totalUserCountNum.setForeground(new Color(127, 118, 104));
		totalUserCountNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalUserCountNum.setSize(totalUserCountNum.getPreferredSize());

		// 총 시간 표시
		JLabel totalUserTime = new JLabel("이용하실 시간");
		totalUserTime.setLocation(300, 170);
		totalUserTime.setForeground(new Color(127, 118, 104));
		totalUserTime.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalUserTime.setSize(totalUserTime.getPreferredSize());

		// 총 시간 - 시간 표시
		totalUserTimeNum = new JLabel("01:00");
		totalUserTimeNum.setLocation(434, 170);
		totalUserTimeNum.setForeground(new Color(127, 118, 104));
		totalUserTimeNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalUserTimeNum.setSize(totalUserTimeNum.getPreferredSize());


		// 시간 텍스트 설정
		JLabel userTime = new JLabel("시간");
		userTime.setLocation(359, 104);
		userTime.setForeground(new Color(127, 118, 104));
		userTime.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		userTime.setSize(userTime.getPreferredSize());


		// +, - 버튼 설정
		countUpBtn = new JButton("+");
		countDownBtn = new JButton("-");
		countUpBtn.setBounds(44, 234, 200, 44);
		countDownBtn.setBounds(44, 330, 200, 44);
		countUpBtn.setBackground(new Color(127, 118, 104));
		countDownBtn.setBackground(new Color(127, 118, 104));
		countUpBtn.setForeground(Color.WHITE);
		countUpBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		countDownBtn.setForeground(Color.WHITE);
		countDownBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		countUpBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		countDownBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		countUpBtn.addActionListener(this);
		countDownBtn.addActionListener(this);

		timeUpBtn = new JButton("+");
		timeDownBtn = new JButton("-");

		timeUpBtn.setBounds(294, 234, 200, 44);
		timeDownBtn.setBounds(294, 330, 200, 44);
		timeUpBtn.setBackground(new Color(127, 118, 104));
		timeDownBtn.setBackground(new Color(127, 118, 104));
		timeUpBtn.setForeground(Color.WHITE);
		timeUpBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		timeDownBtn.setForeground(Color.WHITE);
		timeDownBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		timeUpBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		timeDownBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		timeUpBtn.addActionListener(this);
		timeDownBtn.addActionListener(this);

		// 인원 표시
		countDisplay = new JLabel(count + "명");
		timeDisplay = new JLabel("01:00");

		countDisplay.setBounds(44, 284, 200, 40);
		countDisplay.setBackground(Color.WHITE);
		countDisplay.setForeground(new Color(127, 118, 104));
		countDisplay.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		countDisplay.setBorder(BorderFactory.createEmptyBorder());
		countDisplay.setHorizontalAlignment(JLabel.CENTER);

		timeDisplay.setBounds(294, 284, 200, 40);
		timeDisplay.setBackground(Color.WHITE);
		timeDisplay.setForeground(new Color(127, 118, 104));
		timeDisplay.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		timeDisplay.setBorder(BorderFactory.createEmptyBorder());
		timeDisplay.setHorizontalAlignment(JLabel.CENTER);

		// 버튼 설정
		cancelBtn = new JButton("Cancel");
		confirmBtn = new JButton("Confirm");

		cancelBtn.setBounds(25, 394, 240, 50);
		confirmBtn.setBounds(275,394, 240, 50);
		cancelBtn.setBackground(new Color(189, 177, 157));
		confirmBtn.setBackground(new Color(163, 152, 134));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		cancelBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		confirmBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		cancelBtn.addActionListener(this);
		confirmBtn.addActionListener(this);

		this.add(title);
		this.add(userCount);
		this.add(userTime);
		this.add(totalUserCount);
		this.add(totalUserCountNum);
		this.add(totalUserTime);
		this.add(totalUserTimeNum);
		this.add(countUpBtn);
		this.add(countDownBtn);
		this.add(countDisplay);
		this.add(timeUpBtn);
		this.add(timeDownBtn);
		this.add(timeDisplay);
		this.add(cancelBtn);
		this.add(confirmBtn);

	}

	public int[] popPosition(int w, int h) {
		int[] position = new int[2];

		position[0] = (962 - w) / 2;
		position[1] = (662 - h) / 2 + 20;

		return position;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == timeUpBtn) {
			if (term < 9 && term > 0) {
				++term;

				totalUserTimeNum.setText("0" + term + " : 00");
				totalUserTimeNum.setSize(totalUserTimeNum.getPreferredSize());
				timeDisplay.setText("0" + term + " : 00");
				timeDisplay.setHorizontalAlignment(JLabel.CENTER);
			} else if (term < 23 && term > 8) {
				++term;
				
				totalUserTimeNum.setText(term + " : 00");
				totalUserTimeNum.setSize(totalUserTimeNum.getPreferredSize());
				timeDisplay.setText(term + " : 00");
				timeDisplay.setHorizontalAlignment(JLabel.CENTER);
			}
		}
		if(e.getSource() == timeDownBtn) {
			if (term < 9 && term > 1) {
				--term;
				
				totalUserTimeNum.setText("0" + term + " : 00");
				totalUserTimeNum.setSize(totalUserTimeNum.getPreferredSize());
				timeDisplay.setText("0" + term + " : 00");
				timeDisplay.setHorizontalAlignment(JLabel.CENTER);
			} else if (term < 24 && term > 8) {
				--term;
				
				totalUserTimeNum.setText(term + " : 00");
				totalUserTimeNum.setSize(totalUserTimeNum.getPreferredSize());
				timeDisplay.setText(term + " : 00");
				timeDisplay.setHorizontalAlignment(JLabel.CENTER);
			}
		}
		if(e.getSource() == countUpBtn) {
	
			if(count >= minNum && count < maxNum) {
				++count;
				
				totalUserCountNum.setText(count + "명");
				totalUserCountNum.setSize(totalUserCountNum.getPreferredSize());
				countDisplay.setText(count + "명");
				countDisplay.setHorizontalAlignment(JLabel.CENTER);
			}
		}
		if(e.getSource() == countDownBtn) {
			if(count > minNum && count <= maxNum) {
				--count;
				
				totalUserCountNum.setText(count + "명");
				totalUserCountNum.setSize(totalUserCountNum.getPreferredSize());
				countDisplay.setText(count + "명");
				countDisplay.setHorizontalAlignment(JLabel.CENTER);
			}
		}
		
		if(e.getSource() == cancelBtn) {
			cp.reSeatPanel(mf, this, op2, new AdmSeatTable(mf, this, client, phoneNum, utList, "-", u));     
		}

		if(e.getSource() == confirmBtn) {
			client.sendUser(ad.enterSeatGrp(phoneNum, term, count, selectSeat));

			mf.remove(this);
			mf.remove(op);
			mf.remove(op2);
		}

	}

}