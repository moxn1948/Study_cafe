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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskPasswordDoNot;
import com.kh.studyCafe.kosk.view.popup.KoskPasswordIs;

public class KoskPsswdMf extends JPanel implements ActionListener{
	private JPanel panel;
	private JTextField passwd1;
	private JTextField passwd2;
	private JButton cancel;
	private JButton find;
	private JButton button;
	private String phoneNum;
	private KoskMainFrame mf;
	// 네트워크 코드
	private ClientBack client;
	
	public KoskPsswdMf(KoskMainFrame mf, String phoneNum, ClientBack client) {
		this.mf = mf;
		this.phoneNum = phoneNum;
		// 네트워크 코드
		this.client = client;
		
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

		passwd1 = new JPasswordField(4);
		passwd1.setBounds(120,230,200,40);

		JLabel psswdch = new JLabel("비밀번호");
		JLabel psswdch2 = new JLabel("확인");
		psswdch.setBounds(30,290,100,30);
		psswdch2.setBounds(30,310,60,30);
		psswdch.setFont(inputtext);
		psswdch2.setFont(inputtext);
		psswdch.setForeground(textColor);
		psswdch2.setForeground(textColor);

		passwd2 = new JPasswordField(4);
		passwd2.setBounds(120,295,200,40);

		Image cancelimg2 = new ImageIcon("img/cancelbtnimg2.png").getImage().getScaledInstance(100, 40, 0);

		cancel = new JButton(new ImageIcon(cancelimg2));
		cancel.setBorderPainted(false);
		cancel.setBounds(20,530,100,40);
		cancel.addActionListener(this);
		
		find = new JButton("확인버튼");
		find.setFont(checktext);
		find.setHorizontalAlignment(JButton.CENTER);
		find.setBackground(findbtnColor);
		find.setBorderPainted(false);
		find.setBounds(220,530,100,40);
		find.addActionListener(this);
		//===============================

		this.add(text);
		this.add(ib);
		this.add(psswdch);
		this.add(psswdch2);
		this.add(passwd1);
		this.add(psswdcg);
		this.add(psswdcg2);
		this.add(passwd2);
		this.add(cancel);
		this.add(find);
	
		mf.add(this, 0);
		mf.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancel) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		if(e.getSource() == find) {
			String str1 = passwd1.getText();
			String str2 = passwd2.getText();
			if(str1.equals(str2)) {
				KoskDao kd = new KoskDao();
				kd.changePasswd(phoneNum, passwd1.getText());
				ChangePanel.addPanel(mf, this, new KoskPasswordIs(mf, this, client));
			}else {
				ChangePanel.addPanel(mf, this, new KoskPasswordDoNot(mf, this, phoneNum, client));
			}
		}
		
	}

}