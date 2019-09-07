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
import javax.swing.SwingUtilities;

public class KoskPayment extends JPanel{

	public KoskMainFrame mf;
	public JPanel panel = new JPanel();
	public  KoskPayment(KoskMainFrame mf) {
		this.mf = mf;
		
		//======= 컬러 설정 ====	
		
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
						
		//=================
		
		//================ Frame 설정 ======================
			panel.setSize(360,640);
			panel.setLayout(null);
			panel.setBackground(wallPapers);
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
			
			JButton logout = new JButton(new ImageIcon(logoutimg));
			logout.setBounds(1,1,80,30);
			logout.setBorderPainted(false);
			
			Image mypageimg = new ImageIcon("img/mypagebtnimg.png").getImage().getScaledInstance(80, 30, 0);
			JButton mypage = new JButton(new ImageIcon(mypageimg));
			mypage.setBounds(259, 1, 80, 30);
			mypage.setBorderPainted(false);
			
			JButton money = new JButton("현금");
			money.setFont(font);
			money.setBackground(paper);
			money.setForeground(paper1);
			money.setBounds(60,250,95,96);
			
			JButton card = new JButton("카드");
			card.setFont(font);
			card.setBackground(paper);
			card.setForeground(paper1);
			card.setBounds(190,250,95,96);
			
			Image backimg = new ImageIcon("img/backbtnimg.png").getImage().getScaledInstance(100, 40, 0);
			JButton back = new JButton(new ImageIcon(backimg));
			back.setBorderPainted(false);
			back.setBounds(20,530,100,40);
			
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
			   
			   back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ChangePanel.changePanel(mf, panel, new KoskSeatManagement(mf));
				}
			});
			   
			   panel.add(ib);
			   panel.add(logout);
			   panel.add(mypage);
			   panel.add(paytext);
			   panel.add(seat2);
			   panel.add(card);
			   panel.add(money);
			   panel.add(back);
			   panel.repaint();
			 
			   mf.add(panel,1);
		
	}
}
