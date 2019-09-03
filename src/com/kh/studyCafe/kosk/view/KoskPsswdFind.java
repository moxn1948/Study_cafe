package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
  
public class KoskPsswdFind extends JPanel{
	
	public KoskPsswdFind() {
		
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
		   
		   JTextField nametf = new JTextField("내용을 입력해주세요");
		   nametf.setBounds(120,230,200,40);

		   JLabel phnumber = new JLabel("휴대폰");
		   JLabel phnumber2 = new JLabel("번호");
		   phnumber.setBounds(30,290,60,30);
		   phnumber2.setBounds(30,310,60,30);
		   phnumber.setFont(inputtext);
		   phnumber2.setFont(inputtext);
		   phnumber.setForeground(textColor);
		   phnumber2.setForeground(textColor);
		   
		   JTextField phtf = new JTextField("내용을 입력해주세요");
		   phtf.setBounds(120,295,200,40);
		   
		   Image cancelimg2 = new ImageIcon("img/cancelbtnimg2.png").getImage().getScaledInstance(100, 40, 0);
		   Image findimg = new ImageIcon("img/findbtnimg.png").getImage().getScaledInstance(100, 40, 0);
		   
		   JButton cancel = new JButton(new ImageIcon(cancelimg2));
		   cancel.setBorderPainted(false);
		   cancel.setBounds(20,530,100,40);
		   JButton find = new JButton(new ImageIcon(findimg));
		   find.setBorderPainted(false);
		   find.setBounds(220,530,100,40);
		   //===============================
		   
		   this.add(text);
		   this.add(ib);
		   this.add(name);
		   this.add(nametf);
		   this.add(phnumber);
		   this.add(phnumber2);
		   this.add(phtf);
		   this.add(cancel);
		   this.add(find);
		
	}
}
