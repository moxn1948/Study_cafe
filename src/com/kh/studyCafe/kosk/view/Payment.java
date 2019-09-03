package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Payment extends JPanel{

	private JPanel Payment;
	public Payment() {
		
		//======= 컬러 설정 ====	
		
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
						
		//=================
		
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
			
			Image outbtnimg = new ImageIcon("img/outbtnimg.png").getImage().getScaledInstance(95, 96, 0);
			JButton money = new JButton(new ImageIcon(outbtnimg));
			money.setBounds(60,250,95,96);
			
			Image exbtnimg = new ImageIcon("img/exbtnimg.png").getImage().getScaledInstance(95, 96, 0);
			JButton card = new JButton(new ImageIcon(exbtnimg));
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
			   
			   this.add(ib);
			   this.add(logout);
			   this.add(mypage);
			   this.add(paytext);
			   this.add(seat2);
			   this.add(card);
			   this.add(money);
			   this.add(back);
		
	}
}
