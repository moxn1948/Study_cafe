package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.kosk.controller.KoskManager;
import com.kh.studyCafe.kosk.view.popup.KoskIndividualPanel;
import com.kh.studyCafe.kosk.view.popup.KoskIndividualPanel2;
import com.kh.studyCafe.kosk.view.popup.KoskTimeHourWeek;
import com.kh.studyCafe.model.vo.User;
 
public class KoskSeatManagement extends JPanel{
	
	public JPanel panel = new JPanel();
	private KoskMainFrame mf;
	private JButton[] button = new JButton[3];
	public KoskSeatManagement(KoskMainFrame mf) {
		
		// 패널 2개 생성
		JPanel pp = new JPanel(); // 시간 기간 선택
		JPanel pp2 = new JPanel();// 1일권
		JPanel pp3 = new JPanel();// 기간권
		this.mf = mf;
		//======= 컬러 설정 ====	
		
		//============== font 설정 =========
				Font siguptext = new Font("Noto Sans KR",Font.BOLD,30);
				Font inputtext = new Font("Noto Sans KR",Font.BOLD,17);
				Font checktext = new Font("Noto Sans KR",Font.BOLD,14);
				Font f1 = new Font("Noto Sans KR",Font.BOLD,25);
				Font font = new Font("맑은 고딕",Font.BOLD,15);
				Color wallPapers = new Color(239,234,222);
				Color textColor = new Color(127,118,104);
				Color paper = new Color(163, 152, 134);
				Color paper1 = new Color(255,255,255);
			 	
		//=================
		
		//================ Frame 설정 ======================
		panel.setSize(360,640);
		panel.setLayout(null);
		panel.setBackground(wallPapers);
		//================================================
		
		
		
		//==== 이미지 아이콘  ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);			
		ib.setBounds(150,0,50,50);
				
		//===============================
		
		//=================
		//===== individual confirm 버튼 ====
		Image confirmimg = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
		JButton indicon = new JButton(new ImageIcon(confirmimg));
		indicon.setBounds(139, 280, 117, 50);
		
		//===============================
		//===== individual2 confirm 버튼 ====
		Image confirm2img = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
		JButton indi2con = new JButton(new ImageIcon(confirm2img));
		indi2con.setBounds(139, 280, 117, 50);
		//=================================
		
		//====  1일권 버튼================
		JButton j = new JButton("1일권");
		j.setFont(font);
		j.setBackground(paper);
		j.setForeground(paper1);
		j.setSize(125,68);
		j.setLocation(20, 70);
		
		//====================================
		//======= 기간권 ==================
		JButton j2 = new JButton("기간권");
		j2.setFont(font);
		j2.setBackground(paper);
		j2.setForeground(paper1);
		j2.setBounds(165, 70, 125, 68);
		//=================================
		
		pp.add(j2);
		pp.add(j);
		pp.setSize(310,250);
		pp.setBackground(wallPapers);
		pp.setLayout(null);
		pp.setLocation(20, 100);
		
		
		//==============================
		
		
		Image cancelimg = new ImageIcon("img/Cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
		JButton ticancel = new JButton(new ImageIcon(cancelimg));
		ticancel.setBounds(20, 280, 117, 50);
	
		JButton ticancel2 = new JButton(new ImageIcon(cancelimg));
		ticancel2.setBounds(20, 280, 117, 50);
		
		pp2.add(indicon);
		pp2.add(ticancel);
		pp2.setSize(300,400);
		pp2.setLayout(null);
		pp2.setLocation(20, 100);
		
		pp3.add(indi2con);
		pp3.add(ticancel2);
		pp3.setSize(300,400);
		pp3.setLayout(null);
		pp3.setLocation(20, 100);
		
		//================
		
		//== 버튼 설정  =========
		Image logoutimg = new ImageIcon("img/logoutbtnimg.png").getImage().getScaledInstance(80, 30, 0);
		
		JButton logout = new JButton(new ImageIcon(logoutimg));
		logout.setBounds(1,1,80,30);
		logout.setBorderPainted(false);
		
		Image mypageimg = new ImageIcon("img/mypagebtnimg.png").getImage().getScaledInstance(80, 30, 0);
		JButton mypage = new JButton(new ImageIcon(mypageimg));
		mypage.setBounds(259, 1, 80, 30);
		mypage.setBorderPainted(false);
		
		Image outbtnimg = new ImageIcon("img/outbtnimg.png").getImage().getScaledInstance(95, 96, 0);
		JButton out = new JButton(new ImageIcon(outbtnimg));
		out.setBounds(20,200,95,96);
		button[0] = out;
		
		Image exbtnimg = new ImageIcon("img/exbtnimg.png").getImage().getScaledInstance(95, 96, 0);
		JButton ex = new JButton(new ImageIcon(exbtnimg));
		ex.setBounds(122,200,95,96);
		button[1] = ex; 
		
		Image setmvimg = new ImageIcon("img/seatmvbtnimg.png").getImage().getScaledInstance(95, 96, 0);
		JButton seatmv = new JButton(new ImageIcon(setmvimg));
		seatmv.setBounds(225, 200, 95, 96);
		button[2] = seatmv;
		
		//==================
		
		//==== �� ======
		
		  JLabel seatM = new JLabel("좌석 관리"); //�̸� ��
		   seatM.setBounds(100, 80, 200, 30);
		   seatM.setFont(siguptext);
		   seatM.setForeground(textColor);
		
		//============
		   
		//==== �¼� ��ġ ǥ�� ==========
		  
		   JLabel seat2 = new JLabel("이용중인 좌석");
		   seat2.setBounds(80,110,200,40);
		   seat2.setFont(inputtext);
		   seat2.setForeground(textColor);
		   
		   JTextField seat = new JTextField("4-B번") {
			   @Override
			   public void setBorder(Border border) {
				   
			   }
		   };
		   seat.setBounds(200,110,200,40);
		   seat.setFont(inputtext);
		   seat.setForeground(textColor);
		   seat.setBackground(wallPapers);
		
		   
		  //====================
		 // koskIndividualpanel 에서 취소버튼
		  
		   KoskIndividualPanel ki = new KoskIndividualPanel();
		
		panel.add(logout);
		panel.add(ib);
		panel.add(mypage);
		panel.add(seatM);
		panel.add(seat);
		panel.add(seat2);
		panel.add(out);
		panel.add(ex);
		panel.add(seatmv);
		
		//=============== 테두리 선언 부분 ========================
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
		//=====================================================
		mf.add(panel,1);
		mf.repaint();
		
		 indicon.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					KoskManager kkm = new KoskManager();
					System.out.println(kkm.gettime()+"시간 선택함");
					
					ChangePanel.changePanel(mf, panel, new KoskPayment(mf));
				}
			});
		 indi2con.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, panel, new KoskPayment(mf));
			}
		});
		 mf.repaint();
		KoskTimeHourWeek kth = new KoskTimeHourWeek();
		ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				seat.enable(false);
				for(int i = 0; i < button.length; i++) {
					button[i].setEnabled(false);
					button[i].setVisible(false);
				}
				
				
				pp.setBorder(oneTb);
				panel.add(pp,0);
				mf.repaint();
				
			}
		});
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mf.remove(panel);
				mf.repaint();
				mf.add(new KoskLogin(mf));
				mf.repaint();
			}
		});
		seatmv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ChangePanel.changePanel(mf, panel, new KoskSeatTable(mf));
			   
			}
		});
		  j.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel.remove(pp);
					panel.repaint();   
					KoskIndividualPanel ti = new KoskIndividualPanel();
					pp2.add(ti.KoskIndividualPanel(mf));
					panel.add(pp2,0);
					panel.repaint();
					
					
				}
			});
			j2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel.remove(pp);
					KoskIndividualPanel2 ti2 = new KoskIndividualPanel2();
					pp3.add(ti2.KoskIndividualPanel2(mf));
					panel.add(pp3,0);
					panel.repaint();
					
				}
			});

		 ticancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel.remove(pp2);
					panel.repaint();
					seat.enable(true);
					for(int i = 0; i < button.length; i++) {
						button[i].setEnabled(true);
						button[i].setVisible(true);
					}
					
				}
			});
		   
		   ticancel2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel.remove(pp3);
					panel.repaint();
					seat.enable(true);
					for(int i = 0; i < button.length; i++) {
						button[i].setEnabled(true);
						button[i].setVisible(true);
					}
					
				}
			});
		   
		  
		   
		 
		
	}
}

