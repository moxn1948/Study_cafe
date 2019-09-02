package com.kh.studyCafe.kosk.view.popup;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class KoskSignUp {
	public KoskSignUp() {
		Font font = new Font("Noto Sans KR",Font.BOLD,15);
		Color textColor = new Color(127,118,104);
		Color wallPapers = new Color(205, 201, 191);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);
		
		JFrame mf = new JFrame();
		mf.setSize(310,250);
		
		JPanel panel = new JPanel();
		panel.setSize(310,250);
		panel.setBackground(wallPapers);
		panel.setLayout(null);
		
		JButton button = new JButton("OK");
		button.setBounds(5,140,280,40);
		button.setBackground(paper);
		button.setForeground(paper1);
		
		JLabel label = new JLabel("회원가입이 완료 되었습니다.");
		label.setFont(font);
		label.setBounds(5,60,280,40);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		mf.add(panel);
		panel.add(button);
		panel.add(label);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new KoskSignUp();
	}
}   


