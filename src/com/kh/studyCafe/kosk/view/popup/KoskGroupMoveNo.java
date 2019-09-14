package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class KoskGroupMoveNo extends JPanel implements ActionListener{
	private KoskMainFrame mf;
	private JPanel panel;
	private ClientBack client;
	private JButton button;
	public KoskGroupMoveNo(KoskMainFrame mf,JPanel panel ,ClientBack client) {
		this.mf = mf;
		this.panel = panel;
		this.client = client;

		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Color textColor = new Color(127,118,104);
		Color wallPapers = new Color(205, 201, 191);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);

		this.setSize(295,215);
		this.setLocation(30, 120);
		this.setBackground(wallPapers);
		this.setLayout(null);

		button = new JButton("OK");
		button.setBounds(5,140,280,40);
		button.setBackground(paper);
		button.setForeground(paper1);
		button.addActionListener(this);

		JLabel label = new JLabel("그룹은 자리이동이 불가합니다");
		label.setFont(font);
		label.setBounds(5,60,280,40);
		label.setHorizontalAlignment(JLabel.CENTER);

		this.add(button);
		this.add(label);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			ChangePanel.popchangePanel(mf, this, panel);
		}
	}

}   