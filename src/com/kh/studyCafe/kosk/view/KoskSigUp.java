package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
  
public class KoskSigUp extends JPanel{
	private KoskMainFrame mf;
	private JPanel sigup;
	public KoskSigUp() {
		//========= JFrame ���� ============
		this.setSize(360,640);
		//===============================
		
		//===== ���� ���� =====
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
				 
		//==================
				   
		
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
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);
		ib.setBounds(150,0,50,50);
		//===============================
		
		//=======  ȸ�� ����  ���� ================
	   JLabel text = new JLabel("회원가입");
	   text.setBounds(110,80,150,50);
	   text.setLayout(null);
	   text.setFont(siguptext);
	   text.setForeground(textColor);
		//===================================
	
		//========= �Է� ĭ ===================
	   JLabel name = new JLabel("이름"); //�̸� ��
	   name.setBounds(30, 170, 40, 30);
	   name.setFont(inputtext);
	   name.setForeground(textColor);
	   
	   JLabel phnumber = new JLabel("휴대폰");
	   JLabel phnumber2 = new JLabel("번호");
	   phnumber.setBounds(30,230,60,30);
	   phnumber2.setBounds(30,250,60,30);
	   phnumber.setFont(inputtext);
	   phnumber2.setFont(inputtext);
	   phnumber.setForeground(textColor);
	   phnumber2.setForeground(textColor);
	   
	   JLabel psswd = new JLabel("비밀번호");
	   psswd.setBounds(30,310,80,30);
	   psswd.setForeground(textColor);
	   psswd.setFont(inputtext);
	   
	   JLabel psswdch = new JLabel("비밀번호");
	   JLabel psswdch2 = new JLabel("확인");
	   psswdch.setBounds(30, 370,80,30);
	   psswdch2.setBounds(30,390,60,30);
	   psswdch.setFont(inputtext);
	   psswdch2.setFont(inputtext);
	   psswdch.setForeground(textColor);
	   psswdch2.setForeground(textColor);
	   
	   JTextField nametf = new JTextField("내용을 입력해주세요");
	   nametf.setBounds(120,165,200,40);

	   JTextField phtf = new JTextField("내용을 입력해주세요");
	   phtf.setBounds(120,235,200,40);
	   
	   JTextField pstf = new JTextField("내용을 입력해주세요");
	   pstf.setBounds(120,305,200,40);
	   
	   JTextField psch = new JTextField("내용을 입력해주세요");
	   psch.setBounds(120,375,200,40);
	   //===================================
	   
	   //======  ��ư ========================
	   Image cancelbtn = new ImageIcon("img/cancelbtnimg.png").getImage().getScaledInstance(140, 50, 0);
	   Image confirmbtn = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(140, 50, 0);
	   	JButton cancel = new JButton(new ImageIcon(cancelbtn));
	   	cancel.setBounds(20,500,140,50);
	   	JButton confirm = new JButton(new ImageIcon(confirmbtn));
	   	confirm.setBounds(180,500,140,50);
	   
	   //=====================================
	   	
	   	//====== üũ �ڽ� ======================
	   	JCheckBox checkbox = new JCheckBox("   [필수] 제 3자 이용자 동의 약관");
	   	checkbox.setBounds(40,450,400,30);
	   	checkbox.setBackground(wallPapers);
	   	checkbox.setFont(checktext);
	   	checkbox.setForeground(textColor);
	   	
	   	
	   	//====================================
		this.add(text);
		this.add(ib);
		this.add(name);
		this.add(nametf);
		this.add(phnumber);
		this.add(phnumber2);
		this.add(phtf);
		this.add(psswd);
		this.add(pstf);
		this.add(psswdch);
		this.add(psswdch2);
		this.add(psch);
		this.add(cancel);
		this.add(confirm);
		this.add(checkbox);
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf,sigup, new KoskLogin(mf));
				
			}
		});
		
		
		
		
		
	}

}
