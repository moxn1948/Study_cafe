package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class RemainTimePopup extends JPanel implements ActionListener{
	private KoskMainFrame mf;
	private JPanel panel;
	private ClientBack client;
	
	private JButton button;
	
	public RemainTimePopup(KoskMainFrame mf, JPanel panel, ClientBack client) {
		this.mf = mf;
		this.panel = panel;
		this.client = client;
		
		KoskMainFrame.koskWatchPanel = this;
		
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color textColor = new Color(127,118,104);
		Color wallPapers = new Color(205, 201, 191);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);
		
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
		
		this.setSize(310,180);
		this.setLocation(25, 230);
		this.setBorder(oneTb);
		this.setBackground(wallPapers);
		this.setLayout(null);
		
		button = new JButton("OK");
		button.setBounds(15,120,280,40);
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);
		button.addActionListener(this);
		
		JLabel label = new JLabel();
		label.setFont(font);
		label.setText("1일권 시간연장은 남은 시간이 ");
		label.setBounds(15,45,280,40);
		label.setHorizontalAlignment(JLabel.CENTER);
	     
		JLabel label1= new JLabel();
		label1.setFont(font);
	    label1.setText("30분 이하일 때만 연장이 가능합니다.");
		label1.setBounds(15,60,280,40);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label);
		this.add(label1);
		this.add(button);
		
		mf.add(this, 0);
		mf.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			ChangePanel.popchangePanel(mf, this, panel);
		}
		
	}

}
