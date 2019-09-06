package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class AdmSeatTable extends JPanel implements ActionListener, MouseListener{
	private JButton seatIndv[] = new JButton[25];
	private JButton seatGrp[] = new JButton[5];
	private boolean seatIndvToggle[] = new boolean[25];
	private boolean seatGrpToggle[] = new boolean[5];
	private boolean seatToggle;
	private JPanel op = null;
	
	public AdmSeatTable(AdmMainFrame mf, JPanel op) {
		this.op = op;
		
		// 패널 설정
		int w = 404;
		int h = 548;
		int x = popPosition(w, h)[0];
		int y = popPosition(w, h)[1];
		
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
		}
		
		for (int i = 0; i < seatGrp.length; i++) {
			seatGrp[i].addMouseListener(this);
		}
		
		
		// 버튼 설정
		JButton cancelBtn = new JButton("Cancel");
		JButton confirmBtn = new JButton("Confirm");
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
			
		for (int i = 0; i < seatIndv.length; i++) {

			if(e.getSource() == seatIndv[i]) {
					if(!seatIndvToggle[i]) {
						if(!seatToggle) {
	
							seatIndv[i].setBackground(new Color(127, 118, 104));
							seatIndv[i].setForeground(Color.WHITE);
							
							seatIndvToggle[i] = true;
							seatToggle = true;
						}
					}else {
	
						seatIndv[i].setBackground(Color.WHITE);
						seatIndv[i].setForeground(new Color(127, 118, 104));
						
						seatIndvToggle[i] = false;
						seatToggle = false;
					}
					
			}
		}
		

		for (int i = 0; i < seatGrp.length; i++) {

			if(e.getSource() == seatGrp[i]) {
				if(!seatGrpToggle[i]) {
					if(!seatToggle) {
						seatGrp[i].setBackground(new Color(127, 118, 104));
						seatGrp[i].setForeground(Color.WHITE);
						
						seatGrpToggle[i] = true;
						seatToggle = true;
					}
				}else {
					seatGrp[i].setBackground(Color.WHITE);
					seatGrp[i].setForeground(new Color(127, 118, 104));
					
					seatGrpToggle[i] = false;
					seatToggle = false;
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
