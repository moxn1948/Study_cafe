package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskGroupPanel;
import com.kh.studyCafe.kosk.view.popup.KoskTimeHourWeek;
import com.kh.studyCafe.model.vo.User;

public class KoskSeatTable2 extends JPanel implements MouseListener, ActionListener {
	private JButton seatIndv[] = new JButton[26];
	private JButton seatGrp[] = new JButton[5];
	private int light;
	private boolean seatToggle;
	
	private KoskMainFrame mf;
	private ClientBack client;
	private JButton logout;
	private JButton mypage;
	private JButton confirm;
	private String seatNum;
	private ArrayList<User> uList;
	public static String phnum;
	private int indvOrGrp;
	private int tableOrManage;
	
	public KoskSeatTable2(KoskMainFrame mf,ArrayList<User> uList, ClientBack client,String phnum) {
//		
		KoskDao kd = new KoskDao();
		this.mf = mf;
		this.uList = uList;
		this.client = client;
		this.phnum = phnum;
		// 네트워크 코드
		KoskMainFrame.koskWatchPanel = this;
		
		// 패널 설정
		this.setLayout(null);
		this.setBounds(0, 0, 360, 640);
		this.setBackground(new Color(239,234,222));
		 
		// title 텍스트 설정
		JLabel title = new JLabel("좌석표");
		title.setLocation(130 , 71);
		title.setForeground(new Color(127, 118, 104));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		title.setSize(title.getPreferredSize());
		
		// 로고 설정
		Image icon = new ImageIcon("img/logo.png").getImage().getScaledInstance(26, 34, 0);
		JLabel logoIcon = new JLabel(new ImageIcon(icon));
		logoIcon.setLocation(165, 12);
		logoIcon.setSize(26, 34);

		// 로그아웃 버튼
		logout = new JButton("로그아웃");
		logout.setLocation(0, 7);
		logout.setForeground(new Color(127, 118, 104));
		logout.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		logout.setSize(logout.getPreferredSize());
		logout.setOpaque(false);
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.addActionListener(this);
		
		// 마이페이지 버튼
		mypage = new JButton("마이페이지");
		mypage.setLocation(235, 7);
		mypage.setForeground(new Color(127, 118, 104));
		mypage.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		mypage.setSize(mypage.getPreferredSize());
		mypage.setOpaque(false);
		mypage.setContentAreaFilled(false);
		mypage.setBorderPainted(false);
		mypage.addActionListener(this);
		
		// 좌석표 설정
		JLayeredPane seat = new JLayeredPane();
		seat.setBounds(19, 153, 318, 370);
		
		// 좌석표 배치
		for (int i = 0; i < seatIndv.length; i++) {
			String seatNo = i + 1 + "";
			seatIndv[i] = new JButton(seatNo);
			seatIndv[i].setSize(37, 37);
			seatIndv[i].setBackground(Color.WHITE);
			seatIndv[i].setForeground(new Color(127, 118, 104));
			seatIndv[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			seatIndv[i].setBorder(BorderFactory.createEmptyBorder());
			seatIndv[i].addMouseListener(this);
			seat.add(seatIndv[i]);

			if(i < 5) {
				seatGrp[i] = new JButton(seatNo);
				seatGrp[i].setBackground(Color.WHITE);
				seatGrp[i].setForeground(new Color(127, 118, 104));
				seatGrp[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
				seatGrp[i].setBorder(BorderFactory.createEmptyBorder());
				seatGrp[i].addMouseListener(this);
				seat.add(seatGrp[i]);
			}
		}
		

		seatIndv[0].setLocation(0, 0);
		seatIndv[1].setLocation(42, 0);
		seatIndv[2].setLocation(84, 0);
		seatIndv[3].setLocation(127, 0);
		seatIndv[4].setLocation(169, 0);
		seatIndv[5].setLocation(0, 88);
		seatIndv[6].setLocation(42, 88);
		seatIndv[7].setLocation(84, 88);
		seatIndv[8].setLocation(127, 88);
		seatIndv[9].setLocation(169, 88);
		seatIndv[10].setLocation(0, 129);
		seatIndv[11].setLocation(42, 129);
		seatIndv[12].setLocation(84, 129);
		seatIndv[13].setLocation(127, 129);
		seatIndv[14].setLocation(169, 129);
		seatIndv[15].setLocation(0, 205);
		seatIndv[16].setLocation(42, 205);
		seatIndv[17].setLocation(84, 205);
		seatIndv[18].setLocation(127, 205);
		seatIndv[19].setLocation(169, 205);
		seatIndv[20].setLocation(0, 246);
		seatIndv[21].setLocation(42, 246);
		seatIndv[22].setLocation(84, 246);
		seatIndv[23].setLocation(127, 246);
		seatIndv[24].setLocation(169, 246);

		seatGrp[0].setText("4-A");
		seatGrp[1].setText("4-B");
		seatGrp[2].setText("8-A");
		seatGrp[3].setText("6-A");
		seatGrp[4].setText("6-B");

		seatGrp[0].setSize(100, 70);
		seatGrp[1].setSize(100, 70);
		seatGrp[2].setSize(100, 136);
		seatGrp[3].setSize(159, 74);
		seatGrp[4].setSize(159, 74);

		seatGrp[0].setLocation(217, 0);
		seatGrp[1].setLocation(217, 73);
		seatGrp[2].setLocation(217, 147);
		seatGrp[3].setLocation(0, 292);
		seatGrp[4].setLocation(163, 292);
		
		// 이미 사용 중인 좌석 처리
		for (int i = 0; i < seatIndv.length; i++) {
			
			for(int j = 0; j < uList.size(); j++) {
				if(uList.get(j).getSeatNum().equals((i+1) + "")) {
					seatIndv[i].setBackground(new Color(127, 118, 104));
					seatIndv[i].setForeground(Color.WHITE);
					seatIndv[i].setEnabled(false);
					seatIndv[i].removeMouseListener(this);
				}
			}

		}

		for (int i = 0; i < seatGrp.length; i++) {
			
			for(int j = 0; j < uList.size(); j++) {
				if(uList.get(j).getSeatNum().equals(seatGrp[i].getText())) {
					seatGrp[i].setBackground(new Color(127, 118, 104));
					seatGrp[i].setForeground(Color.WHITE);
					seatGrp[i].setEnabled(false);
					seatGrp[i].removeMouseListener(this);					
				}
			}
		}
		
		  if(!(uList.get(kd.userindex(phnum)).getSeatNum().equals("-")|| uList.get(kd.userindex(phnum)).getSeatNum().equals("0"))) { // 이동일 때
		         for (int i = 0; i < seatGrp.length; i++) {
		              seatGrp[i].setEnabled(false);
		              seatGrp[i].removeMouseListener(this);
		              seatGrp[i].setBackground(new Color(127, 118, 104));
					  seatGrp[i].setForeground(Color.WHITE);
		          }
		      }

		// confirm 버튼
		confirm = new JButton("Confirm");
		confirm.setBounds(18, 541, 320, 52);
		confirm.setForeground(Color.WHITE);
		confirm.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		confirm.setBackground(new Color(163, 152, 134));
		confirm.setBorderPainted(false);
		confirm.addActionListener(this);
		


		this.add(title);
		this.add(logoIcon);
		this.add(seat);
		this.add(logout);
		this.add(mypage);
		this.add(confirm);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		KoskDao kd = new KoskDao();
		// 로그아웃 버튼 클릭 시
		if(e.getSource() == logout) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		
		// 마이페이지 버튼 클릭 시
		if(e.getSource() == mypage) {
			ChangePanel.changePanel(mf, this ,new KoskMypage(mf, this,uList, phnum, client));
		}
		
		// confirm 버튼 클릭 시
		if(e.getSource() == confirm) {
			for(int i=0; i<seatIndv.length; i++) {
				seatIndv[i].setEnabled(false);
			}for(int i=0; i<seatGrp.length; i++) {
				seatGrp[i].setEnabled(false);
			}
			if(kd.toEnterInfo(phnum).equals("0")) {
				if(indvOrGrp == 1) {
					tableOrManage = 1; // 시트테이블로 부터 시작
					System.out.println(seatNum+"좌석");
					ChangePanel.addPanel(mf, this, new KoskTimeHourWeek(mf,uList,phnum,client,this,seatNum,tableOrManage));
				} else {
					ChangePanel.addPanel(mf, this, new KoskGroupPanel(mf, uList,phnum,client,this,seatNum,tableOrManage));
					// public KoskGroupPanel(KoskMainFrame mf,ArrayList<User> uList,String phnum, ClientBack client, JPanel panel,int light) {
					System.out.println("그룹 선택");
				}
			}else {
				kd.KoskLineSeat(phnum, seatNum);
				client.sendUser(new AdmDao().admRead());
				ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
			}
			System.out.println("confirm btn");
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		for (int i = 0; i < seatIndv.length; i++) {

			if(e.getSource() == seatIndv[i]) {
				if(seatToggle == false) { // 처음 선택 했을 때
//					for(int j = 0; j < utList.size(); j++) {
//
//					}
					seatIndv[i].setBackground(new Color(127, 118, 104));
					seatIndv[i].setForeground(Color.WHITE);       
					seatNum = (i+1) + "";
					light = i;
					seatToggle = true;            
				}else { // 이미 선택한 좌석이 있을 경우
					if(light >= seatIndv.length) {
						// 기존의 선택 좌석을 선택 해제함
						seatGrp[light-seatIndv.length].setBackground(Color.WHITE);
						seatGrp[light-seatIndv.length].setForeground(new Color(127, 118, 104));   
							
						// 새로 선택한 좌석 선택함
						seatIndv[i].setBackground(new Color(127, 118, 104));
						seatIndv[i].setForeground(Color.WHITE);
						seatNum = (i+1) + "";
						light = i;
					}else {
						// 기존의 선택 좌석을 선택 해제함
						seatIndv[light].setBackground(Color.WHITE);
						seatIndv[light].setForeground(new Color(127, 118, 104));   

						// 새로 선택한 좌석 선택함
						seatIndv[i].setBackground(new Color(127, 118, 104));
						seatIndv[i].setForeground(Color.WHITE);
						seatNum = (i+1) + "";
						light = i;
					}

				}
				indvOrGrp = 1;
			}
		}

		for (int i = 0; i < seatGrp.length; i++) {

			if(e.getSource() == seatGrp[i]) {
				if(seatToggle == false) { // 처음 선택 했을 때
					seatGrp[i].setBackground(new Color(127, 118, 104));
					seatGrp[i].setForeground(Color.WHITE);

					light = i + seatIndv.length;
					seatToggle = true;

						seatNum = seatGrp[i].getText();
				}else { // 이미 선택한 좌석이 있을 경우
					if(light >= seatIndv.length) {
						// 기존의 선택 좌석을 선택 해제함
						seatGrp[light-seatIndv.length].setBackground(Color.WHITE);
						seatGrp[light-seatIndv.length].setForeground(new Color(127, 118, 104));   

						// 새로 선택한 좌석 선택함
						seatGrp[i].setBackground(new Color(127, 118, 104));
						seatGrp[i].setForeground(Color.WHITE);

						light = i + seatIndv.length;
						
						seatNum = seatGrp[i].getText();
					}else {
						// 기존의 선택 좌석을 선택 해제함
						seatIndv[light].setBackground(Color.WHITE);
						seatIndv[light].setForeground(new Color(127, 118, 104));   

						// 새로 선택한 좌석 선택함
						seatGrp[i].setBackground(new Color(127, 118, 104));
						seatGrp[i].setForeground(Color.WHITE);

						light = i + seatIndv.length;
						
						seatNum = seatGrp[i].getText();
					}

				}
				indvOrGrp = 2;
			}
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