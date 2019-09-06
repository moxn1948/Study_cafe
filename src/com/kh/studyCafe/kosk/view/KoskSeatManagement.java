package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.kh.studyCafe.kosk.view.popup.KoskTimeHourWeek;
 
public class KoskSeatManagement extends JPanel{
	
	private JPanel panel = new JPanel();
	private KoskMainFrame mf;
	private JButton[] button = new JButton[3];
	public KoskSeatManagement(KoskMainFrame mf) {
		this.mf = mf;
		//======= 컬러 설정 ====	
		
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);
			 	
		//=================
		
		//================ Frame 설정 ======================
		this.setSize(360,640);
		this.setLayout(null);
		this.setBackground(wallPapers);
		//================================================
		
		//============== font 설정 =========
		Font siguptext = new Font("Noto Sans KR",Font.BOLD,30);
		Font inputtext = new Font("Noto Sans KR",Font.BOLD,17);
		Font checktext = new Font("Noto Sans KR",Font.BOLD,14);
		Font f1 = new Font("Noto Sans KR",Font.BOLD,25);
				
		//============================
		
		//==== 이미지 아이콘  ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);			
		ib.setBounds(150,0,50,50);
				
		//===============================
		
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
		   
		   
		
		this.add(logout);
		this.add(ib);
		this.add(mypage);
		this.add(seatM);
		this.add(seat);
		this.add(seat2);
		this.add(out);
		this.add(ex);
		this.add(seatmv);
		
	
		ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < button.length; i++) {
					button[i].setEnabled(false);
					button[i].setVisible(false);
				}
				
				KoskTimeHourWeek kth = new KoskTimeHourWeek();
				add(kth.KoskTimeHourWeek(),1,0);
				repaint();
				
			}
		});
		
		
		
		this.add(panel);
		this.repaint();
		
	}
	
}

