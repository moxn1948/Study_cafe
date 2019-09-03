package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class KoskGroupPanel extends JPanel{
	 
	public KoskGroupPanel() { 
		
		
		//===== 컬러설정 =====

		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
						 
		//===============
		
		//====  패널 설정 =====
		
		this.setLayout(null);
		this.setBackground(wallPapers);
		
		//================
		
		//============ font 설정 ==========
		Font siguptext = new Font("맑은고딕",Font.BOLD,30);
		Font inputtext = new Font("맑은고딕",Font.BOLD,25);
		Font checktext = new Font("맑은고딕",Font.BOLD,14);
			
		//===============================
		
		//===== 패널 설정 =======
		JPanel panel = new JPanel();
		panel.setSize(300,400);
		panel.setLayout(null);
		panel.setBackground(wallPapers);
		
		//===== 라벨 =========
		JLabel logo = new JLabel("1일권");
		logo.setBounds(100,30,200,30);
		logo.setFont(inputtext);
		logo.setForeground(textColor);
		
		JLabel Rt = new JLabel("잔여 시간");// 잔여시간
		Rt.setBounds(40,80, 100, 30);
		Rt.setFont(checktext);
		Rt.setForeground(textColor);
		
		JLabel et = new JLabel("연장 후 시간"); // 연장 후 시간
		et.setBounds(40, 100, 100, 30);
		et.setFont(checktext);
		et.setForeground(textColor);
		//===================
		
		//====== textField =======
		JTextField Rttime = new JTextField("02:30") {
			  @Override
			   public void setBorder(Border border) {
				   
			   }
		};
		Rttime.setBounds(150, 80, 100, 30);
		Rttime.setFont(checktext);
		Rttime.setForeground(textColor);
		Rttime.setBackground(wallPapers);
		
		JTextField ettime = new JTextField("03:30") {
			@Override
			public void setBorder(Border border) {
				
			}
		};
		ettime.setBounds(150, 100, 100, 30);
		ettime.setBackground(wallPapers);
		ettime.setFont(checktext);
		ettime.setForeground(textColor);
		
		JTextField time = new JTextField("01 : 00");
		time.setBounds(25,175,110,40);
		time.setFont(checktext);
		time.setForeground(textColor);
		time.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField psn = new JTextField("2명");
		psn.setBounds(144,175,110,40);
		psn.setFont(checktext);
		psn.setForeground(textColor);
		psn.setHorizontalAlignment(JTextField.CENTER);
		//================================
		
		//==== 버튼 ========
		Image plusimg = new ImageIcon("img/plusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
		JButton plus = new JButton(new ImageIcon(plusimg));
		plus.setBounds(25, 130, 110, 40);
		
		
		JButton plus2 = new JButton(new ImageIcon(plusimg));
		plus2.setBounds(144, 130, 110, 40);
		
		Image minusimg = new ImageIcon("img/minusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
		JButton	minus = new JButton(new ImageIcon(minusimg));
		minus.setBounds(25, 220, 110, 40);
		
		
		JButton minus2 = new JButton(new ImageIcon(minusimg));
		minus2.setBounds(144, 220, 110, 40);
		
		Image cancelimg = new ImageIcon("img/cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
		JButton cancel = new JButton(new ImageIcon(cancelimg));
		cancel.setBounds(20, 280, 117, 50);
		
		Image confirmimg = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
		JButton confirm = new JButton(new ImageIcon(confirmimg));
		confirm.setBounds(139, 280, 117, 50);
		
		//============
		this.add(panel);
		panel.add(logo);
		panel.add(Rt);
		panel.add(et);
		panel.add(Rttime);
		panel.add(ettime);
		panel.add(plus);
		panel.add(plus2);
		panel.add(time);
		panel.add(psn);
		panel.add(minus);
		panel.add(minus2);
		panel.add(cancel);
		panel.add(confirm);
	}
}
