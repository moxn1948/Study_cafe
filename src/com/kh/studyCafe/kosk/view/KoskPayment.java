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
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.model.vo.User;

public class KoskPayment extends JPanel implements ActionListener{
	private KoskMainFrame mf;
	private ClientBack client;
	private JPanel panel;
	private ArrayList<User> uList;
	private JButton mypage;
	private JButton logout;
	private JButton money;
	private JButton back;
	private int light;
	private long seattime;
	private String phnum;
	private JButton card;
	private JButton back2;
	private JButton button;
	KoskDao kd = new KoskDao();	
	
	public  KoskPayment(KoskMainFrame mf,ArrayList<User> uList,String phnum,ClientBack client, JPanel panel
			,int light,long seattime) {
		// 네트워크 코드
		this.client = client;
		this.panel = panel;
		this.uList = uList;
		this.mf = mf; 
		this.phnum = phnum;
		this.light = light; // 좌석 번호
		this.seattime = seattime; //좌석 시간
		
		KoskMainFrame.koskWatchPanel = this;
		
		//======= 컬러 설정 =  ===	

		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);

		//=================
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		//================ Frame 설정 ======================
		this.setSize(360,640);
		this.setLayout(null);
		this.setBackground(wallPapers);

		//================================================

		//============== font 설정 =========
		Font siguptext = new Font("Noto Sans KR",Font.BOLD,30);
		Font inputtext = new Font("Noto Sans KR",Font.BOLD,17);
		Font checktext = new Font("Noto Sans KR",Font.BOLD,14);
		Font f1 = new Font("Noto Sans KR",Font.BOLD,25);
		Color paper = new Color(163, 152, 134);
		Color paper1 = new Color(255,255,255);
		Font font = new Font("맑은 고딕",Font.BOLD,15);	 	

		//============================

		//==== 이미지 아이콘  ===============

		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);			
		ib.setBounds(150,0,50,50);

		//===============================

		//== 버튼 설정 =========
		Image logoutimg = new ImageIcon("img/logoutbtnimg.png").getImage().getScaledInstance(80, 30, 0);

		logout = new JButton(new ImageIcon(logoutimg));
		logout.setBounds(1,1,80,30);
		logout.setBorderPainted(false);

		Image mypageimg = new ImageIcon("img/mypagebtnimg.png").getImage().getScaledInstance(80, 30, 0);
		mypage = new JButton(new ImageIcon(mypageimg));
		mypage.setBounds(259, 1, 80, 30);
		mypage.setBorderPainted(false);

		money = new JButton("현금");
		money.setFont(font);
		money.setBackground(paper);
		money.setForeground(paper1);
		money.setBounds(60,250,95,96);

		card = new JButton("카드");
		card.setFont(font);
		card.setBackground(paper);
		card.setForeground(paper1);
		card.setBounds(190,250,95,96);

		Image backimg = new ImageIcon("img/backbtnimg.png").getImage().getScaledInstance(100, 40, 0);
		back = new JButton(new ImageIcon(backimg));
		back.setBorderPainted(false);
		back.setBounds(20,530,100,40);

		back2 = new JButton(new ImageIcon(backimg));
		back2.setBorderPainted(false);
		back2.setBounds(20,530,100,40);
		
		button = new JButton("결제가 완료 되었습니다.");
		button.setFont(font);
		button.setBounds(0,0,300,100);
		button.setBackground(new Color(170, 162, 142));
		button.setLocation(9, 6);
		button.setForeground(paper1);
		//==================

		//==== 라벨 설정 ======

		JLabel paytext = new JLabel("결제 선택"); //�̸� ��
		paytext.setBounds(110, 80, 200, 30);
		paytext.setFont(siguptext);
		paytext.setForeground(textColor);

		JLabel seat2 = new JLabel("결제 방식을 선택해주세요");
		seat2.setBounds(80,140,200,40);
		seat2.setFont(inputtext);
		seat2.setForeground(textColor);

		//============
		mypage.addActionListener(this);
		logout.addActionListener(this);
		back.addActionListener(this);
		back2.addActionListener(this);
		money.addActionListener(this);
		button.addActionListener(this);
		card.addActionListener(this);

		this.add(ib);
		this.add(logout);
		this.add(mypage);
		this.add(paytext);
		this.add(seat2);
		this.add(card);
		this.add(money);
		this.add(back);
		this.repaint();
		mf.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mypage) {
			ChangePanel.changePanel(mf, panel, new KoskMypage(mf,this,phnum,client));
		}
		if(e.getSource() == logout) {
			panel.removeAll();
			mf.add(new KoskLogin(mf, client));
			mf.repaint(); //change패널 로 변경
		}
		if(e.getSource() == logout) {
			//ChangePanel.changePanel(mf, panel, new KoskLogin(mf));
		}
		if(e.getSource() == back) {
			ChangePanel.changePanel(mf, panel, panel );
		}
		if(e.getSource() == money) {
			money.setEnabled(false);
			card.setEnabled(false);
			money.setVisible(false);
			card.setVisible(false);
			kd.Kosktimeplus2(uList,light,seattime,phnum);
			System.out.println(light+"페이먼트 좌석 정보");
			ChangePanel.changePanel(mf, panel, new KoskLogin(mf, client));
			/*this.remove(back);
			this.add(back2,0);*/
			mf.repaint();
			if(e.getSource() == button) {
				
			}
			if(e.getSource() == back2) {
				ChangePanel.changePanel(mf, panel, new KoskLogin(mf, client));
			}
		}
		if(e.getSource() == card) {
			money.setEnabled(false);
			card.setEnabled(false);
			money.setVisible(false);
			card.setVisible(false);
			panel.remove(back);
			panel.add(back2);
			mf.add(panel,0);
			if(e.getSource() == back2) {
				ChangePanel.changePanel(mf, panel, new KoskPayment(
						mf,uList,phnum,client,panel,light,seattime));
				
			}
		}
	}
	
}
