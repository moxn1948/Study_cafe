package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KoskCardButton {
	public KoskCardButton() {
		Font font = new Font("Noto Sans KR",Font.BOLD,15);
		Color textColor = new Color(127,118,104);
		Color wallPapers = new Color(205, 201, 191);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);
		
		JFrame mf =new JFrame();
		mf.setSize(320,150);
		
		JPanel panel = new JPanel();
		panel.setSize(320,150);
		panel.setBackground(wallPapers);
		panel.setLayout(null);
		
		
		JButton button = new JButton("현금을 넣어주세요");
		button.setFont(font);
		button.setBounds(0,0,320,100);
		button.setBackground(paper);
		button.setForeground(paper1);
		mf.add(panel);
		panel.add(button);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new KoskCardButton();
	}

}
