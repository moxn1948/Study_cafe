package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.kosk.view.KoskSeatManagement;

public class KoskTimeHourWeek extends JPanel{
	 public static JPanel panel = new JPanel();
	 private JFrame mf ;
	public JPanel KoskTimeHourWeek(KoskMainFrame mf) {
		
		this.mf = mf;
		
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
		Color paper = new Color(163, 152, 134);
		Color paper1 = new Color(255,255,255);
		
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
	   	 
		JPanel panel = new JPanel();
		panel.setSize(310,250);
		panel.setBorder(oneTb);
		panel.setBackground(wallPapers);
		panel.setLayout(null);
		
		JButton button = new JButton("1일권");
		button.setFont(font);
		button.setBounds(20,70,100,68); 
		button.setBackground(paper);
		button.setForeground(paper1);
		
		JButton button1 = new JButton("기간권");
		button1.setFont(font);
		button1.setBounds(140,70,100,68);
		button1.setBackground(paper);
		button1.setForeground(paper1);
		
		
		JButton button2 = new JButton("잔여시간");
		button2.setFont(font);
		button2.setBounds(210,70,100,68);
		button2.setBackground(paper);
		button2.setForeground(paper1);
		
		JLabel label = new JLabel();
		label.setForeground(textColor);
		panel.setOpaque(true);
		
		mf.add(panel);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KoskIndividualPanel kin = new KoskIndividualPanel();
				panel.removeAll();
				panel.add(kin.KoskIndividualPanel(mf));
				panel.repaint();
				
				
			}
		});
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KoskIndividualPanel2 kin2 = new KoskIndividualPanel2();
				panel.removeAll();
				panel.add(kin2.KoskIndividualPanel2(mf));
				panel.repaint();
			}
		});
		
		
	
		//panel.add(button);
		//panel.add(button1);
		
		return panel;
		
		
	
	}

}
