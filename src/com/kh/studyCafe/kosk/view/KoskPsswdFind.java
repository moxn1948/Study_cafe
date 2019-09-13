package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.PhantomReference;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskPasswordDoNot;

public class KoskPsswdFind extends JPanel implements ActionListener{
	private JPanel panel;
	private JTextField nametf;
	private JTextField phtf;
	private JButton cancel;
	private JButton find;
	private KoskPsswdMf kpm;
	private KoskMainFrame mf;
	//User에서 값을 이름, 핸드폰 번호 , 비밀번호 값 받아와서 저장
	
	// 네크워크 코드
	private ClientBack client;

	public KoskPsswdFind(KoskMainFrame mf, JPanel panel, ClientBack client) {
		this.mf = mf;
		this.client = client;
		// 네크워크 코드
		this.client = client;
		
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		
		// ============= 색상 설정 ===============
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
		//===============================

		//============ font 설정 ==========
		Font siguptext = new Font("Noto Sans KR",Font.BOLD,30);
		Font inputtext = new Font("Noto Sans KR",Font.BOLD,17);
		Font checktext = new Font("Noto Sans KR",Font.BOLD,14);

		//===============================

		//============= 패널 설정 ===============
		this.setSize(360,640);
		this.setLayout(null);
		this.setBackground(wallPapers);
		
		//=================================

		//==== 아이콘 이미지  ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);			
		ib.setBounds(150,0,50,50);

		//===============================

		//======= 제목  ================
		JLabel text = new JLabel("비밀번호 찾기");
		text.setBounds(75,80,300,50);
		text.setLayout(null);
		text.setFont(siguptext);
		text.setForeground(textColor);
		//===================================

		//=== 라벨 설정 =========

		JLabel name = new JLabel("이름");
		name.setBounds(30, 230, 40, 30);
		name.setFont(inputtext);
		name.setForeground(textColor);

		nametf = new JTextField(11);
		nametf.setBounds(120,230,200,40);

		JLabel phnumber = new JLabel("휴대폰");
		JLabel phnumber2 = new JLabel("번호");
		phnumber.setBounds(30,290,60,30);
		phnumber2.setBounds(30,310,60,30);
		phnumber.setFont(inputtext);
		phnumber2.setFont(inputtext);
		phnumber.setForeground(textColor);
		phnumber2.setForeground(textColor);

		phtf = new JTextField(4);
		phtf.setBounds(120,295,200,40);

		Image cancelimg2 = new ImageIcon("img/cancelbtnimg2.png").getImage().getScaledInstance(100, 40, 0);
		Image findimg = new ImageIcon("img/findbtnimg.png").getImage().getScaledInstance(100, 40, 0);

		cancel = new JButton(new ImageIcon(cancelimg2));
		cancel.setBorderPainted(false);
		cancel.setBounds(20,530,100,40);
		cancel.addActionListener(this);
		
		find = new JButton(new ImageIcon(findimg));
		find.setBorderPainted(false);
		find.setBounds(220,530,100,40);
		find.addActionListener(this);
		//===============================

		this.add(ib);
		this.add(name);
		this.add(nametf);
		this.add(phnumber);
		this.add(phnumber2);
		this.add(phtf);
		this.add(cancel);
		this.add(find);
		this.add(text);

		mf.add(this, 0);
		mf.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancel) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		if(e.getSource() == find) {
			KoskDao kd = new KoskDao();
			if((kd.compare(phtf.getText(), nametf.getText())) == true) {
				ChangePanel.changePanel(mf, this, new KoskPsswdMf(mf, phtf.toString(), client));
			}else {
				String phoneNum = phtf.getText();
				ChangePanel.addPanel(mf, this, new KoskPasswordDoNot(mf, this, phoneNum, client));
			}
		}
	}

}