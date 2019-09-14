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

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskCardButton;
import com.kh.studyCafe.kosk.view.popup.KoskCashButton;
import com.kh.studyCafe.model.vo.User;

public class KoskPayment extends JPanel implements ActionListener{
	private KoskMainFrame mf;
	private ClientBack client;
	private JPanel panel;
	private ArrayList<User> uList;
	private JButton mypage;
	private JButton logout = new JButton();
	private JButton money;
	private JButton back = new JButton();
	private String seatnum;
	private long seattime;
	private String phnum;
	private int hOfw;
	private int tableOrManage;
	private JButton card;
	private int Personnum;
	private JButton button = new JButton();
	KoskDao kd = new KoskDao();	
	
	public KoskPayment(KoskMainFrame mf,ArrayList<User> uList,String phnum,ClientBack client, JPanel panel
			,String seatnum,long seattime, int hOfw, int tableOrManage, int Personnum) {
		// 네트워크 코드
		this.client = client;
		this.panel = panel;
		this.uList = uList;
		this.mf = mf; 
		this.phnum = phnum;
		this.seatnum = seatnum; // 좌석 번호
		this.seattime = seattime; //좌석 시간
		this.hOfw = hOfw;
		this.tableOrManage = tableOrManage;
		this.Personnum = Personnum;
		System.out.println("seatTime : " + seattime);
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
		Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
		Font inputtext = new Font("맑은 고딕",Font.BOLD,17);
		Font inputtext2 = new Font("맑은 고딕",Font.BOLD,18);
		Font inputtext3 = new Font("맑은 고딕",Font.BOLD,19);
		Font checktext = new Font("맑은 고딕",Font.BOLD,14);
		Font f1 = new Font("맑은 고딕",Font.BOLD,25);
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

		logout.setIcon(new ImageIcon(logoutimg));
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
		back.setIcon(new ImageIcon(backimg));
		back.setBorderPainted(false);
		back.setBounds(20,530,100,40);
		
		button.setText("결제가 완료 되었습니다.");
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
		
		JLabel payMoney = new JLabel("   원 금액");
		payMoney.setLocation(56, 370);
		payMoney.setFont(inputtext2);
		payMoney.setForeground(textColor);
		payMoney.setSize(payMoney.getPreferredSize());
		
		JLabel dcMoney = new JLabel("- 할인 금액");
		dcMoney.setLocation(60, 404);
		dcMoney.setFont(inputtext2);
		dcMoney.setForeground(textColor);
		dcMoney.setSize(dcMoney.getPreferredSize());
		
		JLabel fpayMoney = new JLabel("총 결제 금액");
		fpayMoney.setLocation(60, 446);
		fpayMoney.setFont(inputtext3);
		fpayMoney.setForeground(textColor);
		fpayMoney.setSize(fpayMoney.getPreferredSize());
		
		if(hOfw == 2) {
			seattime = seattime* 24;
		}
		
		JLabel payMoney2 = new JLabel((seattime*1500*Personnum)+"원");
		payMoney2.setLocation(180, 370);
		payMoney2.setFont(inputtext2);
		payMoney2.setForeground(textColor);
		payMoney2.setSize(payMoney2.getPreferredSize());
		
		JLabel dcMoney2 = new JLabel(((seattime*kd.discount(phnum))+"원"));
		dcMoney2.setLocation(180, 404);
		dcMoney2.setFont(inputtext2);
		dcMoney2.setForeground(textColor);
		dcMoney2.setSize(dcMoney2.getPreferredSize());
		
		JLabel fpayMomey2 = new JLabel(((seattime*1500*Personnum)-(seattime*kd.discount(phnum)))+"원");
		fpayMomey2.setLocation(180, 446);
		fpayMomey2.setFont(inputtext3);
		fpayMomey2.setForeground(textColor);
		fpayMomey2.setSize(fpayMomey2.getPreferredSize());
		
		
		//============
		mypage.addActionListener(this);
		logout.addActionListener(this);
		back.addActionListener(this);
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
		this.add(payMoney);
		this.add(payMoney2);
		this.add(dcMoney);
		this.add(dcMoney2);
		this.add(fpayMoney);
		this.add(fpayMomey2);
		this.repaint();
		mf.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mypage) {
			ChangePanel.changePanel(mf, this, new KoskMypage(mf,this,uList,phnum,client));
		}
		if(e.getSource() == logout) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		if(e.getSource() == back) {
			if(tableOrManage == 1) {
				ChangePanel.changePanel(mf, this, new KoskSeatTable2(mf, uList, client, phnum));
			} else if(tableOrManage == 2){
				ChangePanel.changePanel(mf, this, new KoskSeatManagement(mf, uList, phnum, client, panel, seatnum, seattime));
			}
		}
		if(e.getSource() == card) {
			System.out.println(seatnum+"페이먼트 좌석 정보");
			ChangePanel.addPanel(mf, this, new KoskCardButton(mf, this,uList,seatnum,seattime,phnum,hOfw, client));
		}
		if(e.getSource() == money) {
			System.out.println(seatnum+"페이먼트 좌석 정보");
			ChangePanel.addPanel(mf, this, new KoskCashButton(mf, this,uList,seatnum,seattime,phnum,hOfw, client));
			mf.repaint();
		}
	}
	
}
