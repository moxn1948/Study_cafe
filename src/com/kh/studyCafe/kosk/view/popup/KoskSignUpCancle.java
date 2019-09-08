package com.kh.studyCafe.kosk.view.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class KoskSignUpCancle extends JPanel{
	private KoskMainFrame mf;
		
		public JPanel KoskSignUpCancle(KoskMainFrame mf) {
			this.mf = mf;
			
			Font font = new Font("맑은 고딕",Font.BOLD,15);
			Color textColor = new Color(127,118,104);
			Color wallPapers = new Color(205, 201, 191);
			Color paper = new Color(170, 162, 142);
			Color paper1 = new Color(255,255,255);
			
			
			
			JPanel panel = new JPanel();
			panel.setSize(310,250);
			panel.setBackground(wallPapers);
			panel.setLayout(null);
			
			JButton button1 = new JButton("OK");
			button1.setBounds(5,140,280,40);
			button1.setBackground(paper);
			button1.setForeground(paper1);
			
			JLabel label = new JLabel("회원가입이 취소되었습니다.");
			label.setBounds(5,60,280,40);
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.CENTER);
			 
			mf.add(panel);
			//panel.add(button1);
			panel.add(label);
			
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			return panel;
		}
	
	}   

