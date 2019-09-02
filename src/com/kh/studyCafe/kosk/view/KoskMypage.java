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
  
public class KoskMypage extends JPanel{
	
	public KoskMypage() {
		this.setSize(360,640);
		
		//===== ���� ���� =====
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
				 
		//===============
				
		//===== JPanel ���� =======
		this.setLayout(null);
		this.setBackground(wallPapers);
		//=======================
				
		//============ font ���� ==========
		Font siguptext = new Font("Noto Sans KR",Font.BOLD,30);
		Font inputtext = new Font("Noto Sans KR",Font.BOLD,17);
		Font checktext = new Font("Noto Sans KR",Font.BOLD,14);
	
		//===============================
		
		//==== ���͵� ī�� ������ ���� ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(60, 80, 0);
		JLabel ib = new JLabel("  마이 페이지",(new ImageIcon(imgicon)),SwingUtilities.CENTER);
		ib.setBounds(10,0,250,80);
		ib.setForeground(textColor);
		ib.setFont(siguptext);
		//===============================
		
		//==== �Է¶� ====================
		
		 JLabel name = new JLabel("이름"); //�̸� ��
		   name.setBounds(30, 100, 40, 30);
		   name.setFont(inputtext);
		   name.setForeground(textColor);
		   
		   JLabel phnumber = new JLabel("휴대폰");
		   JLabel phnumber2 = new JLabel("번호");
		   phnumber.setBounds(30,160,60,30);
		   phnumber2.setBounds(30,180,60,30);
		   phnumber.setFont(inputtext);
		   phnumber2.setFont(inputtext);
		   phnumber.setForeground(textColor);
		   phnumber2.setForeground(textColor);
		   
		   JLabel hou1 = new JLabel("이용가능");
		   JLabel hou2 = new JLabel("시간");
		   hou1.setBounds(30,220,80,30);
		   hou2.setBounds(30,240,80,30);
		   hou1.setForeground(textColor);
		   hou1.setFont(inputtext);
		   hou2.setForeground(textColor);
		   hou2.setFont(inputtext);
		   
		   JLabel atime1 = new JLabel("입실시간");
		   atime1.setBounds(30,280,80,30);
		   atime1.setForeground(textColor);
		   atime1.setFont(inputtext);
		   
		   JLabel dtime1 = new JLabel("퇴실시간");
		   dtime1.setBounds(30,340,80,30);
		   dtime1.setForeground(textColor);
		   dtime1.setFont(inputtext);
		   
		   JLabel point1 = new JLabel("포인트");
		   point1.setBounds(30,400,80,30);
		   point1.setForeground(textColor);
		   point1.setFont(inputtext);
		   
		   JLabel rating1 = new JLabel("등급");
		   rating1.setBounds(30,460,80,30);
		   rating1.setForeground(textColor);
		   rating1.setFont(inputtext);
		   
		 
		   
		   JTextField nametf = new JTextField("김진호 님");
		   nametf.setBackground(wallPapers);
		   nametf.setFont(inputtext);
		   nametf.setBounds(120,100,200,40);
		   nametf.setForeground(textColor);
		   
		   JTextField phtf = new JTextField("010-7777-7777");
		   phtf.setBounds(120,160,200,40);
		   phtf.setBackground(wallPapers);
		   phtf.setFont(inputtext);
		   phtf.setForeground(textColor);
		   
		   JTextField hou = new JTextField("4주 12시 26분");
		   hou.setBounds(120,220,200,40);
		   hou.setBackground(wallPapers);
		   hou.setFont(inputtext);
		   hou.setForeground(textColor);
		   
		   JTextField atime = new JTextField("AM 08:00");
		   atime.setBounds(120,280,200,40);
		   atime.setBackground(wallPapers);
		   atime.setFont(inputtext);
		   atime.setForeground(textColor);
		   
		   JTextField dtime = new JTextField("PM 11:59");
		   dtime.setBounds(120,340,200,40);
		   dtime.setBackground(wallPapers);
		   dtime.setFont(inputtext);
		   dtime.setForeground(textColor);
		   
		   JTextField point = new JTextField("9999999p");
		   point.setBounds(120,400,200,40);
		   point.setBackground(wallPapers);
		   point.setFont(inputtext);
		   point.setForeground(textColor);
		   
		   JTextField rating = new JTextField("골드");
		   rating.setBounds(120,460,200,40);
		   rating.setBackground(wallPapers);
		   rating.setFont(inputtext);
		   rating1.setForeground(textColor);
		 //======================================
		   
		 //=== ��ư ===========================

		   Image findimg = new ImageIcon("img/okbtnimg.png").getImage().getScaledInstance(100, 40, 0);
		   
		   JButton find = new JButton(new ImageIcon(findimg));
		   find.setBounds(220,530,100,40);
		
		
		this.add(ib);
		this.add(name);
		this.add(nametf);
		this.add(phtf);
		this.add(hou);
		this.add(atime);
		this.add(dtime);
		this.add(point);
		this.add(rating);
		this.add(hou1);
		this.add(phnumber);
		this.add(phnumber2);
		this.add(atime1);
		this.add(rating1);
		this.add(point1);
		this.add(dtime1);
		this.add(find);
	}
}
