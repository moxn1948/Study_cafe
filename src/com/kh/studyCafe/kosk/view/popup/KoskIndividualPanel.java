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
import javax.swing.border.Border;

public class KoskIndividualPanel implements MouseListener{
	
	JFrame fm = new JFrame();
	private JButton plus;
	private JButton	minus;
	private JButton cancel;
	private JButton confirm;
	private JPanel panel = new JPanel();
	private JTextField time;
	private JTextField Rttime;
	private JTextField ettime;
	private int hour = 0;    //결제시 출력되는 시간
	private int timeHour = 02;    //잔여시간,연장시간에 출력되는 시간(String 변환전)
	private int timeMinute = 30;    //잔여시간, 연장시간에 출력되는 분(String 변환전)
	
	public KoskIndividualPanel(){
	
	
	fm.setBounds(30, 40, 300, 400);
	fm.setLayout(null);
	
	//===== 컬러 =====

	Color wallPapers = new Color(239,234,222);
	Color textColor = new Color(127,118,104);
					
	
     
	Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
	Font inputtext = new Font("맑은 고딕",Font.BOLD,25);
	Font checktext = new Font("맑은 고딕",Font.BOLD,14);
		
   
	
	//===== 패널 =======
	
	panel.setSize(300,400);
	panel.setLayout(null);
	panel.setBackground(wallPapers);
	
	//===== 라벨 =========
	JLabel logo = new JLabel("1일권");
	logo.setBounds(110,30,200,30);
	logo.setFont(inputtext);
	logo.setForeground(textColor);
	
	JLabel Rt = new JLabel("잔여 시간");// 잔여시간
	Rt.setBounds(75, 78, 100, 30);
	Rt.setFont(checktext);
	Rt.setForeground(textColor);
	
	JLabel et = new JLabel("연장 후 시간"); // 연장 후 시간
	et.setBounds(75, 100, 100, 30);
	et.setFont(checktext);
	et.setForeground(textColor);
	//===================
	 
	//====== textField =======
	String th1 = Integer.valueOf(timeHour).toString();
	String tm1 = Integer.valueOf(timeMinute).toString();
	
	Rttime = new JTextField(th1 + ":" + tm1) {
		  @Override
		   public void setBorder(Border border) {
			   
		   }
	};
	Rttime.setBounds(170, 78, 100, 30);
	Rttime.setFont(checktext);
	Rttime.setForeground(textColor);
	Rttime.setBackground(wallPapers);
	
	hour++;
	time = new JTextField("0" + hour + ": 00");
	time.setBounds(85,175,110,40);
	time.setFont(checktext);
	time.setForeground(textColor);
	time.setHorizontalAlignment(JTextField.CENTER);
	time.setEditable(false);
	
	timeHour += hour;
	String th2 = Integer.valueOf(timeHour).toString();
	String tm2 = Integer.valueOf(timeMinute).toString();
	
	ettime = new JTextField(th2 + ":" + tm2) {
		@Override
		public void setBorder(Border border) {
			
		}
	};
	ettime.setBounds(170, 100, 100, 30);
	ettime.setBackground(wallPapers);
	ettime.setFont(checktext);
	ettime.setForeground(textColor);
	ettime.setEditable(false);
	
	//================================
	
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
	panel.add(et);
	panel.add(Rttime);
	panel.add(ettime);
	panel.add(plus);
	panel.add(time);
	panel.add(minus);
	panel.add(cancel);
	panel.add(confirm);
	
	fm.setVisible(true);
	fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == plus) {
			if(hour >= 1 && hour < 9) {
				hour++;
				time.setText("0" + hour + ": 00");
				timeHour += 1;
				String th = Integer.valueOf(timeHour).toString();   
				String tm = Integer.valueOf(timeMinute).toString();  
				ettime.setText(th + ":" + tm);
				
			} else if(hour >= 9 && hour < 23) {
				hour++;
				time.setText(hour + ": 00");
				timeHour += 1;
				String th = Integer.valueOf(timeHour).toString();   
				String tm = Integer.valueOf(timeMinute).toString();  
				ettime.setText(th + ":" + tm);
			}
		}
		
		if(e.getSource() == minus) {
			if(hour > 1 && hour < 9) {
				hour--;
				time.setText("0" + hour + ": 00");
				timeHour -= 1;
				String th = Integer.valueOf(timeHour).toString();   
				String tm = Integer.valueOf(timeMinute).toString();  
				
				ettime.setText(th + ":" + tm);
			} else if(hour >= 9 && hour <= 24) {
				hour--;
				time.setText(hour + ": 00");
				timeHour -= 1;
				String th = Integer.valueOf(timeHour).toString();   
				String tm = Integer.valueOf(timeMinute).toString();  
			}
		}
		
		if(e.getSource() == cancel) {
			fm.dispose();
		}
		if(e.getSource() == confirm) {
			fm.dispose();
			//ChangePanel.changePanel(kst.panel, new KoskPayment());
			//confirm버튼 누를 시 좌석표 패널에서 결제 선택패널로 전환 추가
		}
		
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