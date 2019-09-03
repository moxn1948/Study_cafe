package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KoskPasswordDoNot {
	public KoskPasswordDoNot() {
		
		Font font = new Font("맑은 고딕",Font.BOLD,15);

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
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);
	
		JLabel label = new JLabel();
		label.setFont(font);
		label.setText("�߸� �Է��Ͽ����ϴ�");
		label.setBounds(5,60,280,40);
		label.setHorizontalAlignment(JLabel.CENTER);
	
		JLabel label1= new JLabel();
		label1.setFont(font);
		label1.setText("�̸� Ȥ�� ��ȭ��ȣ��");
		label1.setBounds(5,45,280,40);
		label1.setHorizontalAlignment(JLabel.CENTER);
	
	
		mf.add(panel);
		panel.add(button);
		panel.add(label);
		panel.add(label1);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}   