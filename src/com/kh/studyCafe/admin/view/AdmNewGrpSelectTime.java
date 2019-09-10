package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.kh.studyCafe.client.ClientBack;

public class AdmNewGrpSelectTime extends JPanel implements ActionListener{
	private JButton cancelBtn = null;
	
	public AdmNewGrpSelectTime(AdmMainFrame mf, JPanel op, ClientBack client, String phoneNum) {
	      // 패널 설정
	      int w = 731;
	      int h = 474;
	      int x = popPosition(w, h)[0];
	      int y = popPosition(w, h)[1];
	      
	      
	      this.setLayout(null);
	      this.setBounds(x, y, w, h); 
	      this.setBackground(new Color(239, 234, 222));
	      this.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));


	      JLayeredPane hourLayer = new JLayeredPane();
	      hourLayer.setBounds(30,28,334,349);
	      hourLayer.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));
	      
	      // 인원 텍스트 설정
	      JRadioButton userCount = new JRadioButton("인원");
	      
	      userCount.setBackground(new Color(239, 234, 222));
	      userCount.setLocation(124, 34);
	      userCount.setForeground(new Color(127, 118, 104));
	      userCount.setFont(new Font("맑은 고딕", Font.BOLD, 28));
	      userCount.setSize(userCount.getPreferredSize());
	      
	      // 총 인원 표시
	      JLabel totalUserCount = new JLabel("총 인원");

	      totalUserCount.setLocation(113, 102);
	      totalUserCount.setForeground(new Color(127, 118, 104));
	      totalUserCount.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	      totalUserCount.setSize(totalUserCount.getPreferredSize());
	      
	      // 총 인원 - 명수 표시
	      JLabel totalUserCountNum = new JLabel("2명");

	      totalUserCountNum.setLocation(187, 102);
	      totalUserCountNum.setForeground(new Color(127, 118, 104));
	      totalUserCountNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	      totalUserCountNum.setSize(totalUserCountNum.getPreferredSize());

	      // +, - 버튼 설정
	      JButton countUpBtn = new JButton("+");
	      JButton countDownBtn = new JButton("-");
	      
	      countUpBtn.setBounds(66, 166, 200, 44);
	      countDownBtn.setBounds(66, 262, 200, 44);
	      countUpBtn.setBackground(new Color(127, 118, 104));
	      countDownBtn.setBackground(new Color(127, 118, 104));
	      countUpBtn.setForeground(Color.WHITE);
	      countUpBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
	      countDownBtn.setForeground(Color.WHITE);
	      countDownBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
	      countUpBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
	      countDownBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
	      
	      
	      // 인원 표시
	      JTextField countDisplay = new JTextField("2");
	      countDisplay.setBounds(66, 216, 200, 40);
	      countDisplay.setBackground(Color.WHITE);
	      countDisplay.setForeground(new Color(127, 118, 104));
	      countDisplay.setFont(new Font("맑은 고딕", Font.BOLD, 22));
	      countDisplay.setBorder(BorderFactory.createEmptyBorder());
	      countDisplay.setHorizontalAlignment(JTextField.CENTER);
	      
	      
	      hourLayer.add(userCount);
	      hourLayer.add(totalUserCount); 
	      hourLayer.add(totalUserCountNum);
	      hourLayer.add(countUpBtn);
	      hourLayer.add(countDownBtn);
	      hourLayer.add(countDisplay);
	      

	      JLayeredPane weekLayer = new JLayeredPane();
	      weekLayer.setBounds(368,28,334,349);
	      weekLayer.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));

	      // 시간 텍스트 설정
	      JRadioButton userTime = new JRadioButton("시간");

	      userTime.setBackground(new Color(239, 234, 222));

	      userTime.setLocation(125, 36);
	      userTime.setForeground(new Color(127, 118, 104));
	      userTime.setFont(new Font("맑은 고딕", Font.BOLD, 28));
	      userTime.setSize(userTime.getPreferredSize());


	      // 총 시간 표시
	      JLabel totalUserTime = new JLabel("이용하실 시간");

	      totalUserTime.setLocation(66, 102);
	      totalUserTime.setForeground(new Color(127, 118, 104));
	      totalUserTime.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	      totalUserTime.setSize(totalUserTime.getPreferredSize());
	      
	      // 총 시간 - 시간 표시
	      JLabel totalUserTimeNum = new JLabel("02:00");

	      totalUserTimeNum.setLocation(207, 102);
	      totalUserTimeNum.setForeground(new Color(127, 118, 104));
	      totalUserTimeNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	      totalUserTimeNum.setSize(totalUserTimeNum.getPreferredSize());
	      
	      // +, - 버튼 설정
	      JButton timeUpBtn = new JButton("+");
	      JButton timeDownBtn = new JButton("-");

	      timeUpBtn.setBounds(66, 166, 200, 44);
	      timeDownBtn.setBounds(66, 262, 200, 44);
	      timeUpBtn.setBackground(new Color(127, 118, 104));
	      timeDownBtn.setBackground(new Color(127, 118, 104));
	      timeUpBtn.setForeground(Color.WHITE);
	      timeUpBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
	      timeDownBtn.setForeground(Color.WHITE);
	      timeDownBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
	      timeUpBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
	      timeDownBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));

	      
	      // 시간 표시
	      JTextField timeDisplay = new JTextField("02:00");

	      timeDisplay.setBounds(66, 216, 200, 40);
	      timeDisplay.setBackground(Color.WHITE);
	      timeDisplay.setForeground(new Color(127, 118, 104));
	      timeDisplay.setFont(new Font("맑은 고딕", Font.BOLD, 22));
	      timeDisplay.setBorder(BorderFactory.createEmptyBorder());
	      timeDisplay.setHorizontalAlignment(JTextField.CENTER);

	      weekLayer.add(userTime);
	      weekLayer.add(totalUserTime);
	      weekLayer.add(totalUserTimeNum);
	      weekLayer.add(timeUpBtn);
	      weekLayer.add(timeDownBtn);
	      weekLayer.add(timeDisplay);   
	      
	      // 버튼 설정
	      cancelBtn = new JButton("Cancel");
	      JButton confirmBtn = new JButton("Confirm");

	      cancelBtn.setBounds(30, 390, 334, 50);
	      confirmBtn.setBounds(368,390, 334, 50);
	      cancelBtn.setBackground(new Color(189, 177, 157));
	      confirmBtn.setBackground(new Color(163, 152, 134));
	      cancelBtn.setForeground(Color.WHITE);
	      cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	      confirmBtn.setForeground(Color.WHITE);
	      confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	      cancelBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
	      confirmBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
	      
	      ButtonGroup timeRadio = new ButtonGroup();
	      timeRadio.add(userCount);
	      timeRadio.add(userTime);
	      
	      this.add(hourLayer);
	      this.add(weekLayer);
	      
	      this.add(cancelBtn);
	      this.add(confirmBtn);
		
	}

	public int[] popPosition(int w, int h) {
		int[] position = new int[2];
		
		position[0] = (962 - w) / 2;
		position[1] = (662 - h) / 2;
		
		return position;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
