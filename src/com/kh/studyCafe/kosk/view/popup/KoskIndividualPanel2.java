package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.kosk.controller.KoskManager;
import com.kh.studyCafe.kosk.view.KoskMainFrame;

public class KoskIndividualPanel2 extends JPanel implements MouseListener{
	
	private JFrame fm = new JFrame();
	private JTextField time  = new JTextField("7일");
	private JButton plus;
	private JButton	minus;
	private JButton cancel;
	private JButton confirm;
	private int day = 7;
	public JPanel panel = new JPanel();
	private JLabel Rt;
	
	private KoskMainFrame mf;
	public JPanel KoskIndividualPanel2(KoskMainFrame mf) {
	this.mf = mf;
	
	panel.setSize(300,400);
	panel.setLayout(null);
	
	//===== 컬러 =====

	Color wallPapers = new Color(239,234,222);
	Color textColor = new Color(127,118,104);
					
	  
     
	Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
	Font inputtext = new Font("맑은 고딕",Font.BOLD,25);
	Font checktext = new Font("맑은 고딕",Font.BOLD,14);
		
	TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
	
	
	//===== 패널 =======

	panel = new JPanel();
	panel.setSize(300,400);
	panel.setLayout(null);
	panel.setBackground(wallPapers);
	panel.setBorder(oneTb);
	
	//===== 라벨 =========
	JLabel logo = new JLabel("기간권");
	logo.setBounds(100,30,200,30);
	logo.setFont(inputtext);
	logo.setForeground(textColor);
	
	//====== textField =======
	
	time = new JTextField(day + "일");
	time.setBounds(85,175,110,40);
	time.setFont(checktext);
	time.setForeground(textColor);
	time.setHorizontalAlignment(JTextField.CENTER);
	time.setEditable(false);	 
	
	//================================
	
	Rt = new JLabel("이용하실 기간  " + day + "일");// 잔여시간
	Rt.setBounds(60,80, 150, 60);
	Rt.setFont(checktext);
	Rt.setForeground(textColor);
	Rt.setHorizontalAlignment(JLabel.CENTER);
	
	//===================
	
	
	
	//==== 버튼 ========
	Image plusimg = new ImageIcon("img/plusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
	plus = new JButton(new ImageIcon(plusimg));
	plus.setBounds(85, 130, 110, 40);
	
	plus.addMouseListener(this);
		
	Image minusimg = new ImageIcon("img/minusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
	minus = new JButton(new ImageIcon(minusimg));
	minus.setBounds(85, 220, 110, 40);
	
	minus.addMouseListener(this);

	Image cancelimg = new ImageIcon("img/Cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
	cancel = new JButton(new ImageIcon(cancelimg));
	cancel.setBounds(20, 280, 117, 50);
	
	cancel.addMouseListener(this);
	
	Image confirmimg = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
	confirm = new JButton(new ImageIcon(confirmimg));
	confirm.setBounds(139, 280, 117, 50);
	
	confirm.addMouseListener(this);
	
	
	
	//============
	fm.add(panel);
	panel.add(logo);
	panel.add(Rt);
	panel.add(plus);
	panel.add(time);
	panel.add(minus);
	//panel.add(cancel);
	//panel.add(confirm);
	
	mf.add(panel);
	
	panel.repaint();
	
	return panel;
	
}	
	KoskManager kkm = new KoskManager();
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == plus) {
			if(day >= 7 && day < 28) {
				day += 7;
				time.setText(day + "일");
				Rt.setText("이용하실 기간  " + day + "일");
			}
		}
		if(e.getSource() == minus) {
			if(day > 7 && day <= 28) {
				day -= 7;
				time.setText(day + "일");
				Rt.setText("이용하실 기간  " + day + "일");
			}
		}
		if(e.getSource() == cancel) {
			fm.setVisible(false);
		}
		if(e.getSource() == confirm) {
			fm.setVisible(false);
			//confirm버튼 누를 시 좌석표 패널에서 결제 선택패널로 전환 추가
		}
		 kkm.intime(day);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}