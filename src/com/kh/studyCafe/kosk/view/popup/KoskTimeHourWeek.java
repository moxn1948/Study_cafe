package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class KoskTimeHourWeek extends JPanel{
	 public static JPanel panel = new JPanel();
	public JPanel KoskTimeHourWeek() {

		
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
		Color paper = new Color(163, 152, 134);
		Color paper1 = new Color(255,255,255);
		
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
	   	
		JPanel panel = new JPanel();
		panel.setSize(310,250);
		panel.setBorder(oneTb);
		panel.setLocation(20, 100);
		panel.setBackground(wallPapers);
		panel.setLayout(null);
		
		JButton button = new JButton("1일권");
		button.setFont(font);
		button.setBounds(20,70,125,68); 
		button.setBackground(paper);
		button.setForeground(paper1);
		
		JButton button1 = new JButton("기간권");
		button1.setFont(font);
		button1.setBounds(165,70,125,68);
		button1.setBackground(paper);
		button1.setForeground(paper1);
		JLabel label = new JLabel();
		label.setForeground(textColor);
		
		  
	
		panel.add(button);
		panel.add(button1);
		
		return panel;
	
	}

}
