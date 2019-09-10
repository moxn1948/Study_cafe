package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;

public class AdmSeatTable extends JPanel implements ActionListener, MouseListener{
	private JButton seatIndv[] = new JButton[25];
	private JButton seatGrp[] = new JButton[5];
	private int light;
	private JPanel op = null;
	private JButton cancelBtn = null;
	private JButton confirmBtn = null;
	private boolean seatToggle;
	private AdmMainFrame mf;
	private ClientBack client;
	private String phoneNum;
	private String seatNum;
	private ArrayList<AdmUserTable> utList;

	public AdmSeatTable(AdmMainFrame mf, JPanel op, ClientBack client,String phoneNum, ArrayList<AdmUserTable> utList) {
		this.op = op;
		this.mf = mf;
		this.client = client;
		this.phoneNum = phoneNum;
		this.utList = utList;



		// 패널 설정
		int w = 404;
		int h = 548;
		int x = popPosition(w, h)[0];
		int y = popPosition(w, h)[1];

		this.setLayout(null);
		this.setBounds(x, y, w, h);    

		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		// title 텍스트 설정
		JLabel title = new JLabel("좌석표");

		title.setLocation(156, 40);
		title.setForeground(new Color(127, 118, 104));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		title.setSize(title.getPreferredSize());

		// 좌석표 설정
		JLayeredPane seat = new JLayeredPane();
		seat.setBounds(26, 104, 354, 350);

		// 좌석표 배치

		for (int i = 0; i < seatIndv.length; i++) {
			String seatNo = i + 1 + "";
			seatIndv[i] = new JButton(seatNo);
			seatIndv[i].setSize(40, 40);
			seatIndv[i].setBackground(Color.WHITE);
			seatIndv[i].setForeground(new Color(127, 118, 104));
			seatIndv[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			seatIndv[i].setBorder(BorderFactory.createEmptyBorder());
			seat.add(seatIndv[i]);

			if(i < 5) {
				seatGrp[i] = new JButton(seatNo);
				seatGrp[i].setBackground(Color.WHITE);
				seatGrp[i].setForeground(new Color(127, 118, 104));
				seatGrp[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
				seatGrp[i].setBorder(BorderFactory.createEmptyBorder());
				seat.add(seatGrp[i]);
			}
		}

		seatIndv[0].setLocation(0, 0);
		seatIndv[1].setLocation(45, 0);
		seatIndv[2].setLocation(90, 0);
		seatIndv[3].setLocation(135, 0);
		seatIndv[4].setLocation(180, 0);
		seatIndv[5].setLocation(0, 64);
		seatIndv[6].setLocation(45, 64);
		seatIndv[7].setLocation(90, 64);
		seatIndv[8].setLocation(135, 64);
		seatIndv[9].setLocation(180, 64);
		seatIndv[10].setLocation(0, 114);
		seatIndv[11].setLocation(45, 114);
		seatIndv[12].setLocation(90, 114);
		seatIndv[13].setLocation(135, 114);
		seatIndv[14].setLocation(180, 114);
		seatIndv[15].setLocation(0, 178);
		seatIndv[16].setLocation(45, 178);
		seatIndv[17].setLocation(90, 178);
		seatIndv[18].setLocation(135, 178);
		seatIndv[19].setLocation(180, 178);
		seatIndv[20].setLocation(0, 230);
		seatIndv[21].setLocation(45, 230);
		seatIndv[22].setLocation(90, 230);
		seatIndv[23].setLocation(135, 230);
		seatIndv[24].setLocation(180, 230);

		seatGrp[0].setText("4-A");
		seatGrp[1].setText("4-B");
		seatGrp[2].setText("8-A");
		seatGrp[3].setText("6-A");
		seatGrp[4].setText("6-B");

		seatGrp[0].setSize(104, 60);
		seatGrp[1].setSize(104, 60);
		seatGrp[2].setSize(104, 140);
		seatGrp[3].setSize(172, 62);
		seatGrp[4].setSize(172, 62);

		seatGrp[0].setLocation(246, 0);
		seatGrp[1].setLocation(246, 65);
		seatGrp[2].setLocation(246, 130);
		seatGrp[3].setLocation(0, 287);
		seatGrp[4].setLocation(179, 287);


		for (int i = 0; i < seatIndv.length; i++) {
			seatIndv[i].addMouseListener(this);
			for(int j = 0; j < utList.size(); j++) {
				if(utList.get(j).getSeatNum().equals((i+1) + "")) {
					seatIndv[i].setBackground(new Color(127, 118, 104));
					seatIndv[i].setForeground(Color.WHITE);
					seatIndv[i].setEnabled(false);
					seatIndv[i].removeMouseListener(this);
				}
			}

		}

		for (int i = 0; i < seatGrp.length; i++) {
			seatGrp[i].addMouseListener(this);
			for(int j = 0; j < utList.size(); j++) {
				if(utList.get(j).getSeatNum().equals(seatGrp[i].getText())) {
					seatGrp[i].setBackground(new Color(127, 118, 104));
					seatGrp[i].setForeground(Color.WHITE);
					seatGrp[i].setEnabled(false);
					seatGrp[i].removeMouseListener(this);					
				}
			}
		}


		// 버튼 설정
		cancelBtn = new JButton("Cancel");
		confirmBtn = new JButton("Confirm");

		cancelBtn.setBounds(26, 470, 172, 50);
		confirmBtn.setBounds(204, 470, 173, 50);
		cancelBtn.setBackground(new Color(189, 177, 157));
		confirmBtn.setBackground(new Color(163, 152, 134));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		cancelBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		confirmBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		confirmBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		
		// 패널에 올림
		this.add(title);
		this.add(seat);
		this.add(cancelBtn);
		this.add(confirmBtn);
		
		
	}

	public int[] popPosition(int w, int h) {
		int[] position = new int[2];

		position[0] = (962 - w) / 2;
		position[1] = (662 - h) / 2;

		return position;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource() == cancelBtn) {
			String tempClass = AdmMainFrame.watchPanel.getClass().getName().split("view.")[1];
			if(tempClass.equals("AdmUsingUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			if(tempClass.equals("AdmAllUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
		}
		if(e.getSource() == confirmBtn) {
			AdmDao ao = new AdmDao();
			AdmManager ad = new AdmManager();
			int sn = 0;
			if(!seatNum.contains("-")) {
				sn = Integer.parseInt(seatNum);
			}
			System.out.println(sn);
			System.out.println("phone" + phoneNum);
			
			if(ao.toEnterInfo(phoneNum).equals("0")) { // 자리입실
				if(sn >= 1 && sn <= 25) {
					new ControlPanel().addPanel2(mf, this, new AdmNewIndvSelectTime(mf, op,client,phoneNum));
				}else {
					new ControlPanel().addPanel2(mf, op, new AdmNewGrpSelectTime(mf, op,client,phoneNum));
				}
			}else { // 자리이동
				if(!seatNum.contains("-")) {
					client.sendUser(ad.moveSeatNum(phoneNum, seatNum));
					mf.remove(this);	
				}else {
					System.out.println("그룹좌석으로 이동 안됨");

//					new ControlPanel().changePanel(mf, this, new AdmMoveGrp(mf, op,client));
				}
			}
		}
		//new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), 
		//new AdmDao().admRead(), client));


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