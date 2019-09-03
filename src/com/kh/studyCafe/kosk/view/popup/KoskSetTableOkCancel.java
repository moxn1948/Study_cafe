package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KoskSetTableOkCancel {
	public KoskSetTableOkCancel() {
			Font font = new Font("맑은 고딕",Font.BOLD,15);
			Color textColor = new Color(127,118,104);
			Color wallPapers = new Color(205, 201, 191);
			Color paper = new Color(127, 118, 104);
			Color paper1 = new Color(255,255,255);
			
			
			JFrame mf = new JFrame();
			mf.setSize(310,250);
			
			JPanel panel = new JPanel();
			panel.setSize(310,250);
			panel.setBackground(wallPapers);
			panel.setLayout(null);
			
			JButton button = new JButton("확인");
			button.setBounds(40,140,100,40);
			button.setFont(font);
			button.setBackground(paper);
			button.setForeground(paper1);
			
			JButton button1 = new JButton("취소");
			button1.setBounds(152,140,100,40);
			button1.setFont(font);
			button1.setBackground(paper);
			button1.setForeground(paper1);
			
			
			
			JLabel label = new JLabel();
			label.setFont(font);
			label.setText("좌석을 변경하시겠습니까");
			label.setBounds(5,60,280,40);
			label.setForeground(paper);
			label.setHorizontalAlignment(JLabel.CENTER);
			
		
			
			
			mf.add(panel);
			panel.add(button);
			panel.add(button1);
			panel.add(label);
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
	


