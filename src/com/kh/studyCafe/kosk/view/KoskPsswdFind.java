package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.model.vo.User;

public class KoskPsswdFind extends JPanel{
	private KoskMainFrame mf;
	private JPanel pssfind = new JPanel();
	private JPanel popUp = new JPanel();
	private JTextField nametf;
	private JTextField phtf;
	private JButton cancel;
	private JButton find;
	private KoskPsswdMf kpm;
	//User에서 값을 이름, 핸드폰 번호 , 비밀번호 값 받아와서 저장

	public KoskPsswdFind(KoskMainFrame mf) {
		this.mf = mf;

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
		pssfind.setSize(360,640);
		pssfind.setLayout(null);
		pssfind.setBackground(wallPapers);
		
		popUp.setSize(310,200);
		popUp.setBackground(wallPapers);
		popUp.setLayout(null);
		popUp.setLocation(16, 256);

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
		pssfind.add(nametf);

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
		pssfind.add(phtf);

		Image cancelimg2 = new ImageIcon("img/cancelbtnimg2.png").getImage().getScaledInstance(100, 40, 0);
		Image findimg = new ImageIcon("img/findbtnimg.png").getImage().getScaledInstance(100, 40, 0);

		cancel = new JButton(new ImageIcon(cancelimg2));
		cancel.setBorderPainted(false);
		cancel.setBounds(20,530,100,40);
		find = new JButton(new ImageIcon(findimg));
		find.setBorderPainted(false);
		find.setBounds(220,530,100,40);
		//===============================


		pssfind.add(ib);
		pssfind.add(name);
		pssfind.add(nametf);
		pssfind.add(phnumber);
		pssfind.add(phnumber2);
		pssfind.add(phtf);
		pssfind.add(cancel);
		pssfind.add(find);
		pssfind.add(text);

		mf.add(pssfind);
		mf.repaint();

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, pssfind, new KoskLogin(mf));
			}
		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//등록되어 있는 정보와 입력된 값바 비교 후 맞을 시 이름과 전화번호, 비밀번호 값 전달 / 패널 전환
				KoskDao kd = new KoskDao();
				if((kd.compare(phtf.getText(), nametf.getText())) == true) {
					ChangePanel.changePanel(mf, pssfind, new KoskPsswdMf(mf, phtf.toString()));
				}else {
					phtf.setEditable(false);
					nametf.setEditable(false);
					find.setEnabled(false);
					cancel.setEnabled(false);
					
					JButton button = new JButton("OK");
				      button.setBounds(15,120,280,40);
				      button.setFont(new Font("맑은 고딕",Font.BOLD,15));
				      button.setBackground(new Color(170, 162, 142));
				      button.setForeground(new Color(255,255,255));
				   
				      JLabel label = new JLabel();
				      label.setFont(new Font("맑은 고딕",Font.BOLD,15));
				      label.setText("잘못 입력하였습니다");
				      label.setBounds(15,50,280,40);
				      label.setHorizontalAlignment(JLabel.CENTER);
				        
				      JLabel label1= new JLabel();
				      label1.setFont(new Font("맑은 고딕",Font.BOLD,15));
				      label1.setText("이름 혹은 전화번호를");
				      label1.setBounds(15,35,280,40);
				      label1.setHorizontalAlignment(JLabel.CENTER);
				      
				      popUp.add(button);
				      popUp.add(label);
				      popUp.add(label1);
				      
				      popUp.setBorder(tb);				
				      pssfind.add(popUp,0);
				      mf.repaint();
				      
				      button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							ChangePanel.changePanel(mf, pssfind, new KoskPsswdFind(mf));
						}
					});
				}
			}
		});
		

	}

}