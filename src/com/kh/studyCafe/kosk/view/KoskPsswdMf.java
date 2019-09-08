package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.kh.studyCafe.kosk.view.popup.KoskPasswordDoNot;

public class KoskPsswdMf extends JPanel{
	private KoskMainFrame mf;
	private JPanel pssmf = new JPanel() ;
	private JPanel panel1 = new JPanel();
	private JTextField nametf;
	private JTextField phtf;
	private JButton cancel;
	private JButton find;
	private JButton button;

	public KoskPsswdMf(KoskMainFrame mf) {
		this.mf = mf;

		// ============= 색상 설정 ===============
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
		Color findbtnColor = new Color(205,201,191);
		Color paper = new Color(170, 162, 142);
		Color paper1 = new Color(255,255,255);
		//===============================

		//============ font 설정 ==========
		Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
		Font inputtext = new Font("맑은 고딕",Font.BOLD,17);
		Font checktext = new Font("맑은 고딕",Font.BOLD,14);
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		//===============================

		//============= 패널 설정 ===============
		pssmf.setSize(360,640);
		pssmf.setLayout(null);
		pssmf.setBackground(wallPapers);

		//=================================

		//==== 아이콘 이미지  ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);			
		ib.setBounds(150,0,50,50);

		//===============================

		//======= 제목  ================
		JLabel text = new JLabel("비밀번호 변경");
		text.setBounds(75,80,300,50);
		text.setLayout(null);
		text.setFont(siguptext);
		text.setForeground(textColor);
		//===================================

		//=== 라벨 설정 =========

		JLabel psswdcg = new JLabel("변경할");
		JLabel psswdcg2 = new JLabel("비밀번호");
		psswdcg.setBounds(30, 230, 70, 30);
		psswdcg2.setBounds(30,250,90,30);
		psswdcg.setFont(inputtext);
		psswdcg2.setFont(inputtext);
		psswdcg.setForeground(textColor);
		psswdcg2.setForeground(textColor);

		nametf = new JTextField(4);
		nametf.setBounds(120,230,200,40);
		pssmf.add(nametf);

		JLabel psswdch = new JLabel("비밀번호");
		JLabel psswdch2 = new JLabel("확인");
		psswdch.setBounds(30,290,100,30);
		psswdch2.setBounds(30,310,60,30);
		psswdch.setFont(inputtext);
		psswdch2.setFont(inputtext);
		psswdch.setForeground(textColor);
		psswdch2.setForeground(textColor);

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

		phtf = new JTextField(4);
		phtf.setBounds(120,295,200,40);
		pssmf.add(phtf);

		Image cancelimg2 = new ImageIcon("img/cancelbtnimg2.png").getImage().getScaledInstance(100, 40, 0);

		cancel = new JButton(new ImageIcon(cancelimg2));
		cancel.setBorderPainted(false);
		cancel.setBounds(20,530,100,40);
		find = new JButton("확인버튼");
		find.setFont(checktext);
		find.setHorizontalAlignment(JButton.CENTER);
		find.setBackground(findbtnColor);
		find.setBorderPainted(false);
		find.setBounds(220,530,100,40);
		//===============================
		button = new JButton("OK");
		button.setBounds(5,140,280,40);
		button.setFont(font);
		button.setBackground(paper);
		button.setForeground(paper1);


		pssmf.add(text);
		pssmf.add(ib);
		pssmf.add(psswdch);
		pssmf.add(psswdch2);
		pssmf.add(nametf);
		pssmf.add(psswdcg);
		pssmf.add(psswdcg2);
		pssmf.add(phtf);
		pssmf.add(cancel);
		pssmf.add(find);

		panel1.add(button);
		panel1.add(label);
		panel1.add(label1);
		panel1.setSize(310,250);
		panel1.setBackground(wallPapers);
		panel1.setLayout(null);
		panel1.setLocation(30, 150);		
		mf.add(pssmf);
		mf.repaint();

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf,pssmf, new KoskLogin(mf));
			}
		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nowPasswd = nametf.getText();
				String newPasswd = phtf.getText();

				if(nowPasswd.equals(newPasswd)) {

					ChangePanel.changePanel(mf,pssmf, new KoskLogin(mf));
				}else {
					cancel.setEnabled(false);
					find.setEnabled(false);
					nametf.setEnabled(false);
					phtf.setEnabled(false);
					cancel.setBackground(new Color(205, 201, 191));
					cancel.setForeground(new Color(64, 64, 64));
					pssmf.add(panel1,1);
					//pssmf.repaint();
					mf.repaint();
				}

			}
		});

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pssmf.remove(panel1);
				cancel.setEnabled(true);
				find.setEnabled(true);
				nametf.setEnabled(true);
				phtf.setEnabled(true);
				nametf.setText("");
				phtf.setText("");
				mf.repaint();
			}
		});
	}

}