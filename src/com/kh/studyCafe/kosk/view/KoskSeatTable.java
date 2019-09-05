package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.kosk.controller.KoskManager;
import com.kh.studyCafe.model.vo.User;

public class KoskSeatTable extends JPanel implements MouseListener{
	
	private JButton[] iuser = new JButton[25]; //개인 좌석 버튼
	private JButton[] dfuser = new JButton[2]; //
	private JButton[] dsuser = new JButton[2];
	private JButton[] deuser = new JButton[1];
	private boolean[] inds = new boolean[25];
	private boolean[] grfs = new boolean[2];
	private boolean[] grss = new boolean[2];
	private boolean[] gres = new boolean[1];
	private JPanel panel = new JPanel();
	private KoskMainFrame  mf;
public KoskSeatTable(KoskMainFrame mf) {
	this.mf = mf;
	
	User user = new User();
		
		this.setSize(360, 640);

		int x = 5;
		int y = 152;

		String name = null;
		
		this.setLayout(null);

		// ========= 패널 배경 색 설정, 패널 사이즈 설정 ============

		panel.setBackground(new Color(239, 234, 222));
		panel.setSize(700, 1000);
		
		Font font1 = new Font("맑은 고딕", Font.BOLD, 32);
		JLabel label = new JLabel("좌석표");
		label.setForeground(new Color(127, 118, 104));
		label.setFont(font1);
		label.setLocation(131, 50);
		label.setSize(200, 90);
				
		panel.add(label);
		
		// =========== 상단 로고 이미지 설정 ==================
		Image image = new ImageIcon("imag/logo.png").getImage().getScaledInstance(26, 34, 0);
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		imageLabel.setLocation(167, 12);
		imageLabel.setSize(26, 34);
		
		panel.add(imageLabel);
		
		
		//=======  로그아웃 ===============

		// ================== 로그아웃 버튼 설정  =====================

		JButton logOut = new JButton("로그아웃");
		logOut.setBorderPainted(false);
		logOut.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		logOut.setForeground(new Color(163, 152, 134));
		logOut.setBackground(new Color(239, 234, 222));
		logOut.setLocation(11, 12);
		logOut.setSize(100, 27);
		
		
	//==================== 로그아웃 버튼 이벤트 부분 ===================
		
		

		// ============== 로그아웃 버튼 클릭스 이벤트 =================

		logOut.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf,panel,new KoskLogin(mf));
			}
		});
		panel.add(logOut);
		
		
		//=========== 마이이지 ==============

		// ========== 마이페이지 버튼 설정 ===================

		JButton myPage = new JButton("마이페이지");
		myPage.setBorderPainted(false);
		myPage.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		myPage.setForeground(new Color(163, 152, 134));
		myPage.setBackground(new Color(239, 234, 222));
		myPage.setLocation(220, 12);
		myPage.setSize(140, 27);

		// ============== 마이페이지 버튼 누를 시 이벤트 ================

		myPage.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked (MouseEvent e) {
				// TODO Auto-generated method stub
					
				ChangePanel.changePanel(mf,panel, new KoskMypage(mf));
			}
		});
		
		panel.add(myPage);
		
		panel.setLayout(null);
		
		// =============== 개인 좌석 버튼 설정 ===================
		for(int i = 0; i < iuser.length; i++) {
			String num = i + "";
			iuser[i] = new JButton(num);
			iuser[i].setBackground(Color.WHITE);
			iuser[i].setFont(new Font("맑은 고딕", Font.BOLD, 11));
			iuser[i].setForeground(new Color(163, 152, 134));
			iuser[i].setLocation(x,y);
			iuser[i].setSize(47,47);
			
			iuser[i].addMouseListener(this);
			panel.add(iuser[i]);
			
			x += 48;

			if((i+1) % 5 == 0 && i != 0) {
				if(i == 4 || i == 14) {
					y += 68;
				}else {
					y += 52;
				}
				x = 5;
			}
			
		}
		
		// ================= 4인실룸 버튼 설정 ==================
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				name = "4-A";
				y = 151; 
			} else {
				name = "4-B";
				y += 75;
				
			}
			dfuser[i] = new JButton(name);
			dfuser[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
			dfuser[i].setBackground(Color.WHITE);
			dfuser[i].setForeground(new Color(163, 152, 134));
			dfuser[i].setLocation(250, y);
			dfuser[i].setSize(90, 64);
			
			dfuser[i].addMouseListener(this); 
			panel.add(dfuser[i]);
		}	
				
		//================== 8인실룸 버튼 설정 =====================
		    deuser[0] =new JButton("8-A");
		    deuser[0].setFont(new Font("맑은 고딕", Font.BOLD, 18));
		    deuser[0].setBackground(Color.WHITE);
		    deuser[0].setForeground(new Color(163, 152, 134));
			deuser[0].setLocation(250, 302);
			deuser[0].setSize(90, 140);
			
			deuser[0].addMouseListener(this); 
			panel.add(deuser[0]);
			
			// =============== 6인실룸 버튼 설정 ======================
			for(int i = 0; i < 2; i++) {
				if(i == 0) {
					name = "6-A";
					y = 5;
				}else if(i == 1) {
					name = "6-B";
					y += 172;
				}
				
				dsuser[i] = new JButton(name);
				dsuser[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
				dsuser[i].setBackground(Color.WHITE);
				dsuser[i].setForeground(new Color(163, 152, 134));
				dsuser[i].setLocation(y, 458);
				dsuser[i].setSize(160 , 65);
				
				dsuser[i].addMouseListener(this); 
				panel.add(dsuser[i]);
			}
			
			//========  해당 좌석 정보를 읽어 좌석 색 칠하고 선택 불가능 ==========
			KoskManager kkm = new KoskManager();
			for(int i=0; i<kkm.seat().size();i++) {
				int num=0;
				num = Integer.parseInt((String) kkm.seat().get(i));
				
				if(num>=0 && num<25) {
					iuser[num].setBackground(new Color(163, 152, 134));
					iuser[num].setForeground(Color.WHITE);
				} else if(num>24 && num <27) {
					int num2 = 0;
					if(num == 25) {
						num2 = 0;
					} else {
						num2 = 1;
					}
					dfuser[num2].setBackground(new Color(163, 152, 134));
					dfuser[num2].setForeground(Color.WHITE);
				}
				
				
				//iuser[num].setEnabled(false);
			}
			
			
			
			//================================================
		
		this.add(panel);
		this.repaint();
}
		
	

//============== 좌석 버튼 클릭시 이벤트 ===================
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
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
	User user = new User();
	Font font = new Font("맑은 고딕", Font.BOLD, 16);
	int num = 0;
	// ================= 좌석 선택시 좌석 색깔 변경 설정 =======================
	for(int a = 0; a < inds.length; a++) {
		if(e.getSource() == iuser[a]) {
			if(inds[a] != true) {
				((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
				((JComponent) e.getSource()).setForeground(Color.WHITE);
				num = a;
				user.setSeatNum(Integer.toString(a));
				System.out.println(user.getSeatNum()+"번째 좌석");
			} 
		}
	}
   // ======  4인실  ======
	for(int b = 0; b < grfs.length; b++) {
		if(e.getSource() == dfuser[b]) {
			if(grfs[b] != true) {
				((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
				((JComponent) e.getSource()).setForeground(Color.WHITE);
				user.setSeatNum(Integer.toString(b));
				String seatnum;
				if(b == 0) {
					seatnum = "25";
				} else {
					seatnum = "26";
				}
				
				user.setSeatNum(seatnum);
				System.out.println(user.getSeatNum());
				}

			}
		}
	
	//  ====  6인실 ======
	for(int c = 0; c < grss.length; c++) {
		if(e.getSource() == dsuser[c]) {
			if(grss[c] != true) {
				((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
				((JComponent) e.getSource()).setForeground(Color.WHITE);
				if(c == 0) {
					
				}
				}

			}
		}
	
	// == 8인실  ====
	for(int d = 0; d < gres.length; d++) {
		if(e.getSource() == deuser[d]) {
			if(gres[d] != true) {
				((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
				((JComponent) e.getSource()).setForeground(Color.WHITE);
				
				}

			}
		}
	
	this.repaint();
	
	for(int i = 0; i < inds.length; i++) {
		inds[i] = true;
	}
	for(int f = 0; f < grfs.length; f++) {
		grfs[f] = true;
	}
	for(int s = 0; s < grss.length; s++) {
		grss[s] = true;
	}
		gres[0] = true;
		
		//============== 좌석 선택시 나타나는 선택취소 버튼 설정 ====================
		JButton pre = new JButton("선택취소");
		pre.setFont(font);
		pre.setBackground(new Color(189, 177, 157));
		pre.setForeground(Color.WHITE);
		pre.setLocation(5, 531);
		pre.setSize(160 ,53);
		
		panel.add(pre);

		//==================== 좌석 선택시 나타나는 confirm버튼 설정=========================
		JButton confirm = new JButton("Confirm");
		confirm.setFont(font);
		confirm.setBackground(new Color(163, 152, 134));
		confirm.setForeground(Color.WHITE);
		confirm.setLocation(175, 531);
		confirm.setSize(160,53);

		panel.add(confirm);
		mf.add(panel);
		
		//================= 선택취소 버튼 누를시 이벤트 =======================
		pre.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new KoskSeatTable(mf));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent me) {
		
			}
		});	

		//================ 확인 버튼 누를시 이벤트 =================
		confirm.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			
			
				new KoskManager().seatManger((user.getSeatNum()));
				ChangePanel.changePanel(mf,panel, new KoskLogin(mf));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
}	

}