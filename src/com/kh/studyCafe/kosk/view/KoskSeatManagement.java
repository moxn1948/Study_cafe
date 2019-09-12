
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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskIndividualPanel2;
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
	private int light;
	
	private JButton[] button = new JButton[3];
	private JButton mypage;
	private JButton logout;
	private JButton ticancel;
	private JButton ticancel2;
	private JButton j2;
	private JButton day;
	
	public KoskSeatManagement(KoskMainFrame mf, ArrayList<User> uList,String phnum, 
			ClientBack client, JPanel panel, int light,long seattime) {
		this.mf = mf;
		this.uList = uList;
		this.phnum = phnum;
		this.client = client;
		this.panel = panel;
		this.light = light;
		KoskIndividualPanel2 kip2 = new KoskIndividualPanel2();
	
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
		
		day.setFont(font);
		day.setBackground(paper);
		day.setForeground(paper1);
		day.setSize(125,68);
		day.setLocation(20, 70);
		
		//====================================
		//======= 기간권 ==================
		j2 = new JButton("기간권");
		j2.setFont(font);
		j2.setBackground(paper);
		j2.setForeground(paper1);
		j2.setBounds(165, 70, 125, 68);
		//=================================
		
	
		
		
		//==============================
		
		
		Image cancelimg = new ImageIcon("img/Cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
		ticancel = new JButton(new ImageIcon(cancelimg));
		ticancel.setBounds(20, 280, 117, 50);
	
		ticancel2 = new JButton(new ImageIcon(cancelimg));
		ticancel2.setBounds(20, 280, 117, 50);
		
		
		//================
		
		//== 버튼 설정  =========
		Image logoutimg = new ImageIcon("img/logoutbtnimg.png").getImage().getScaledInstance(80, 30, 0);
		
		logout = new JButton(new ImageIcon(logoutimg));
		logout.setBounds(1,1,80,30);
		logout.setBorderPainted(false);
		
		Image mypageimg = new ImageIcon("img/mypagebtnimg.png").getImage().getScaledInstance(80, 30, 0);
		mypage = new JButton(new ImageIcon(mypageimg));
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
		   
		   JTextField seat = new JTextField() {
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
		mf.add(panel,0);
		mf.repaint();
		int num=0; 
		long time =0;
		//individual 버튼
		 indicon.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println(seatNum);
					ChangePanel.changePanel(mf, panel, new KoskPayment(mf,uList,phnum,client,panel,light,seattime));
				}
			});
		 //individual2 버튼
		 indi2con.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(kip2.daytime()+"시트메니저");
				ChangePanel.changePanel(mf, panel, new KoskPayment(mf,uList,phnum,client,panel,light,seattime));
			}
		});
		 mf.repaint();
		ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				seat.setEnabled(false);
				for(int i = 0; i < button.length; i++) {
					button[i].setEnabled(false);
					button[i].setVisible(false);
				}
				
				
				
			}
		});
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*mf.remove(panel);
				mf.repaint();
				mf.add(new KoskLogin(mf));
				mf.repaint();*/
				
				//koskDao.KoskExitSeat(phoneNum);// 퇴실 
				//ChangePanel.changePanel(mf, panel, new KoskLogin(mf, client));
				
					
			}
		});
		seatmv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(num>=0 && num < 25) {
					ChangePanel.changePanel(mf, panel, new KoskSeatTable2(mf,uList,phnum,client));
				} else {
					//팝업사용
				}
				
			   
			}
		});
			day.addActionListener(this);
			j2.addActionListener(this);
		   ticancel.addActionListener(this);
		   ticancel2.addActionListener(this);
		   logout.addActionListener(this);
		   mypage.addActionListener(this);
		    
		  
		   
		 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mypage) {
			
		}
		if(e.getSource() == logout) {
			ChangePanel.changePanel(mf, panel, new KoskLogin(mf, client));
		}
		if(e.getSource() == ticancel2) {
			
		}
	}
}
