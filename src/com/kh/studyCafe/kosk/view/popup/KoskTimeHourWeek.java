package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KoskTimeHourWeek extends JPanel{
	public KoskTimeHourWeek() {
		
		
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
		Color paper = new Color(163, 152, 134);
		Color paper1 = new Color(255,255,255);
		JFrame jm = new JFrame();
		jm.setSize(310,250);
		
	   	
		JPanel panel = new JPanel();
		panel.setSize(310,250);
		panel.setBackground(wallPapers);
		panel.setLayout(null);
		
		JButton button = new JButton("1�ϱ�");
		button.setFont(font);
		button.setBounds(10,70,125,68);
		button.setBackground(paper);
		button.setForeground(paper1);
		
		JButton button1 = new JButton("�Ⱓ��");
		button1.setFont(font);
		button1.setBounds(155,70,125,68);
		button1.setBackground(paper);
		button1.setForeground(paper1);
		JLabel label = new JLabel();
		label.setForeground(textColor);
		
		
		jm.add(panel);
		panel.add(button);
		panel.add(button1);
		
		
		
		
		jm.setVisible(true);
		jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
