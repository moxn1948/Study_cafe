package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class KoskPassWordNo extends JPanel{
		private KoskMainFrame mf;
		
		public JPanel KoskPassWordNo(KoskMainFrame mf) {
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
			      
			JButton button = new JButton("OK");
			button.setBounds(5,140,280,40);
			button.setBackground(paper);
			button.setForeground(paper1);
			
			JLabel label = new JLabel("비밀번호가 일치하지 않습니다");
			label.setFont(font);
			label.setBounds(5,60,280,40);
			label.setHorizontalAlignment(JLabel.CENTER);
			  
			mf.add(panel);
			//panel.add(button);
			panel.add(label);
			
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			return panel;
		}

	}   


