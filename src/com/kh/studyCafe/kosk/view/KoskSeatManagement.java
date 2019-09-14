
package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskExit;
import com.kh.studyCafe.kosk.view.popup.KoskTimeHourWeek;
import com.kh.studyCafe.model.vo.User;
 
public class KoskSeatManagement extends JPanel implements ActionListener{
	
	public JPanel panel;
	JPanel backpanel ;
	private KoskMainFrame mf ;
	
	private int onum;
	private String seatNum;
	private String phnum;
	private ClientBack client;
	private ArrayList<User> uList;
	private String seatnum;
	private long seattime;
	private JButton[] button = new JButton[3];
	
	private JButton mypage = new JButton();
	private JButton logout = new JButton();
	private JButton out = new JButton();
	private JButton seatmv = new JButton();
	private JButton ex = new JButton();
	private int tableOrManage;
	KoskDao kd = new KoskDao();
	
	public KoskSeatManagement(KoskMainFrame mf, ArrayList<User> uList,String phnum, 
			ClientBack client, JPanel panel, String seatnum,long seattime) {
		this.mf = mf;
		this.uList = uList;
		this.phnum = phnum;
		this.client = client;
		this.panel = panel;
		this.seatnum = seatnum;
		this.tableOrManage = tableOrManage;
		this.seattime = seattime;
	
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
		this.setSize(360,640);
		this.setLayout(null);
		this.setBackground(wallPapers);
		//================================================
		
		
		
		//==== 이미지 아이콘  ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(30, 30, 0);
		JLabel ib = new JLabel("",(new ImageIcon(imgicon)),SwingUtilities.CENTER);			
		ib.setBounds(150,0,50,50);
				
		//===============================
		
		
		//== 버튼 설정  =========
		Image logoutimg = new ImageIcon("img/logoutbtnimg.png").getImage().getScaledInstance(80, 30, 0);
		logout.setIcon(new ImageIcon(logoutimg));
		logout.setBounds(1,1,80,30);
		logout.setBorderPainted(false);
		
		Image mypageimg = new ImageIcon("img/mypagebtnimg.png").getImage().getScaledInstance(80, 30, 0);
		mypage.setIcon(new ImageIcon(mypageimg));
		mypage.setBounds(275,1, 80, 30);
		mypage.setBorderPainted(false);
		
		Image outbtnimg = new ImageIcon("img/outbtnimg.png").getImage().getScaledInstance(95, 96, 0);
		out.setIcon(new ImageIcon(outbtnimg));
		out.setBounds(20,200,95,96);
		button[0] = out;
		
		Image exbtnimg = new ImageIcon("img/exbtnimg.png").getImage().getScaledInstance(95, 96, 0);
		ex.setIcon(new ImageIcon(exbtnimg));
		ex.setBounds(122,200,95,96);
		button[1] = ex; 
		
		Image setmvimg = new ImageIcon("img/seatmvbtnimg.png").getImage().getScaledInstance(95, 96, 0);
		seatmv.setIcon(new ImageIcon(setmvimg));
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
		   
		   
		   JLabel seat = new JLabel(uList.get(kd.userindex(phnum)).getSeatNum()+" 번 좌석") {
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
		  
		
		this.add(logout);
		this.add(ib);
		this.add(mypage);
		this.add(seatM);
		this.add(seat);
		this.add(seat2);
		this.add(out);
		this.add(ex);
		this.add(seatmv);
		 
		//=============== 테두리 선언 부분 ========================
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
		//=====================================================
		 	ex.addActionListener(this);
			out.addActionListener(this);
			seatmv.addActionListener(this);
		    logout.addActionListener(this);
		    mypage.addActionListener(this);
		    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		KoskDao kd = new KoskDao();
		
		if(e.getSource() == mypage) {
			ChangePanel.changePanel(mf, this ,new KoskMypage(mf, this, phnum, client));
		}
		if(e.getSource() == logout) {
			ChangePanel.changePanel(mf, this, new KoskLogin(mf, client));
		}
		
		if(e.getSource() == seatmv) {
			if(seatnum.length() == 3) {
				//팝업
			}else if(Integer.parseInt(seatnum) > 0 && Integer.parseInt(seatnum) <= 25) {
				ChangePanel.changePanel(mf, this, new KoskSeatTable2(mf,uList,client, phnum));
			}
		}
		if(e.getSource() == out) {
			out.setVisible(false);
			ChangePanel.addPanel(mf, this, new KoskExit(mf, this, phnum, client));
		}
		if(e.getSource() == ex) {
			for(int i=0; i< button.length; i++) {
				button[i].setVisible(false);
			}
			tableOrManage = 2;
			ChangePanel.addPanel(mf, this, new KoskTimeHourWeek(mf, uList, phnum, client, backpanel, seatnum,tableOrManage));
		}
		
	}
}
