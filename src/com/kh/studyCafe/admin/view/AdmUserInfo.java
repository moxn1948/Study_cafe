package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;

public class AdmUserInfo extends JPanel implements ActionListener{
	private JPanel op = null;
	private JButton deleteBtn;
	private JButton closeBtn;
	private AdmMainFrame mf;
	private ClientBack client;
	
	//패널설정
	 public AdmUserInfo(AdmMainFrame mf, User u, JPanel op, ClientBack client) {
		this.op = op;
		this.mf = mf;
		this.client = client;
		
		 System.out.println("AdmUserInfo : " + u);
		 // [name=달님, phoneNum=010-2222-2222, password=pas24, seatNum=16, inTime=1567869060000, outTime=1568732400000, remainTime=620908207, seatType=2, point=100, pointTime=863340000, rank=gold]
		 
		 this.setBounds(300,120,362,484);
		 this.setBackground(new Color(239,234,222));
		 this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
	 
	 
		 //title 설정
		 JLabel title =  new JLabel("회원 정보");
		 title.setLocation(116,16);
		 title.setForeground(new Color(127,118,104));
		 title.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		 title.setSize(title.getPreferredSize());
	 
		 
		 // 회원 정보 출력
		 JLabel name = new JLabel("이름");
		 name.setLocation(40, 65);
		 name.setForeground(new Color(163, 152, 134));
		 name.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 name.setSize(name.getPreferredSize());
		 
		 JLabel namePut = new JLabel(u.getName());
		 namePut.setLocation(170, 65);
		 namePut.setForeground(new Color(163, 152, 134));
		 namePut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 namePut.setSize(namePut.getPreferredSize());
				 
		 JLabel phone = new JLabel("전화번호");
		 phone.setLocation(40,93);
		 phone.setForeground(new Color(163, 152, 134));
		 phone.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 phone.setSize(phone.getPreferredSize());
		 
		 JLabel phonePut = new JLabel(u.getPhoneNum());
		 phonePut.setLocation(170, 93);
		 phonePut.setForeground(new Color(163, 152, 134));
		 phonePut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 phonePut.setSize(phonePut.getPreferredSize());
		 
		 JLabel seatNum = new JLabel("좌석번호");
		 seatNum.setLocation(40,125);
		 seatNum.setForeground(new Color(163, 152, 134));
		 seatNum.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 seatNum.setSize(seatNum.getPreferredSize());
		 
		 String seatNumStr;
		 if(u.getSeatNum().equals("0")) {
			 seatNumStr = "-";
		 }else {
			 seatNumStr = u.getSeatNum();
		 }
		 JLabel seatPut = new JLabel(seatNumStr);
		 seatPut.setLocation(170, 125);
		 seatPut.setForeground(new Color(163, 152, 134));
		 seatPut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 seatPut.setSize(seatPut.getPreferredSize());
		 
		 JLabel checkIn = new JLabel("입실시간");
		 checkIn.setLocation(40,157);
		 checkIn.setForeground(new Color(163, 152, 134));
		 checkIn.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 checkIn.setSize(checkIn.getPreferredSize());


		SimpleDateFormat sdf = new SimpleDateFormat("hh : mmaa");
		String inTimeStr;
		if(u.getInTime() == 0) {
			inTimeStr = "-";
		}else {
			inTimeStr = sdf.format(u.getInTime());
			if(inTimeStr.split("오")[1].equals("전")) {
				inTimeStr = inTimeStr.split("오")[0] + "AM";
			}else {
				inTimeStr = inTimeStr.split("오")[0] + "PM";
			}
		}
        JLabel inTime = new JLabel(inTimeStr);
        inTime.setLocation(170, 157);
        inTime.setForeground(new Color(163, 152, 134));
        inTime.setFont(new Font("맑은 고딕",Font.BOLD,20));
        inTime.setSize(inTime.getPreferredSize());
		 
		 
		 
		 
		 
		 
		 
		 JLabel checkOut = new JLabel("퇴실예정시간");
		 checkOut.setLocation(40, 189);
		 checkOut.setForeground(new Color(163, 152, 134));
		 checkOut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 checkOut.setSize(checkOut.getPreferredSize());
		 
		 
		 JLabel outTime = new JLabel(u.getOutTime() + "");
		 
		 outTime.setLocation(170, 189);
		 outTime.setForeground(new Color(163, 152, 134));
		 outTime.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 outTime.setSize(outTime.getPreferredSize());
		 
		 
		 
		 
		 
		 JLabel remain = new JLabel("잔여시간");
		 remain.setLocation(40, 221);
		 remain.setForeground(new Color(163, 152, 134));
		 remain.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 remain.setSize(remain.getPreferredSize());
		 
		 
		 JLabel remainPut = new JLabel(u.getRemainTime() + "");
		 remainPut.setLocation(170, 221);
		 remainPut.setForeground(new Color(163, 152, 134));
		 remainPut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 remainPut.setSize(remainPut.getPreferredSize());
		 
		 
		 
		 
		 JLabel remain2 = new JLabel("시간");
		 remain2.setLocation(186, 221);
		 remain2.setForeground(new Color(163, 152, 134));
		 remain2.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 remain2.setSize(remain.getPreferredSize());
		 
		 
		 
		 
		 
		 JLabel pNum = new JLabel("개인/단체");
		 pNum.setLocation(40, 253);
		 pNum.setForeground(new Color(163, 152, 134));
		 pNum.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 pNum.setSize(pNum.getPreferredSize());
		 
		 
		 JLabel pNumPut = new JLabel("개인");
		 pNumPut.setLocation(170, 253);
		 pNumPut.setForeground(new Color(163, 152, 134));
		 pNumPut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 pNumPut.setSize(pNum.getPreferredSize());
		 
		 
		 
		 
		 
		 

		 JLabel point = new JLabel("포인트");
		 point.setLocation(40, 285);
		 point.setForeground(new Color(163, 152, 134));
		 point.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 point.setSize(point.getPreferredSize());
		 
		 
		 JLabel pointPut = new JLabel(u.getPoint() + "P");
		 
		 
		 pointPut.setLocation(170,285);
		 pointPut.setForeground(new Color(163, 152, 134));
		 pointPut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 pointPut.setSize(pointPut.getPreferredSize());
		 
		 
		 
				 
		 
		 JLabel grade = new JLabel("등급");
		 grade.setLocation(40, 317);
		 grade.setForeground(new Color(163, 152, 134));
		 grade.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 grade.setSize(grade.getPreferredSize());
		

		 JLabel gradePut = new JLabel(u.getRank());
		 
		 gradePut.setLocation(170, 317);
		 gradePut.setForeground(new Color(163, 152, 134));
		 gradePut.setFont(new Font("맑은 고딕",Font.BOLD,20));
		 gradePut.setSize(gradePut.getPreferredSize());
		 
		 
		 
		 
		 
		 
		 closeBtn = new JButton("Close");
		 closeBtn.setBounds(30, 376, 303, 50);
		 closeBtn.setBackground(new Color(163, 152, 134));
		 closeBtn.setFont(new Font("맑은 고딕",Font.BOLD,18));
		 closeBtn.setForeground(Color.WHITE);
		 closeBtn.setBorderPainted(false);
		 closeBtn.addActionListener(this);
		 
		 
		 
		 
		 
		 
		 
		 deleteBtn = new JButton("<html><u>회원 삭제하기</u></html>");
		
		 deleteBtn.setBounds(84,430,200,21);
		 deleteBtn.setBorderPainted(false);
		 deleteBtn.setContentAreaFilled(false);
		 deleteBtn.setForeground(new Color(127,118,104));
		 deleteBtn.setFont(new Font("맑은 고딕",Font.PLAIN,14));
		 deleteBtn.addActionListener(this);
		 
		 
		 
		 
		 this.add(title);
		 this.add(name);
		 this.add(namePut);
		 this.add(phone);
		 this.add(phonePut);
		 this.add(seatNum);
		 this.add(seatPut);
		 this.add(checkIn);
		 this.add(checkOut);
		 this.add(outTime);
		 this.add(remain);//잔여시간
		 this.add(remainPut);
		 this.add(remain2);
		 this.add(pNum);
		 this.add(pNumPut);
		 this.add(point);
		 this.add(pointPut);//이거 p물어봐야지
		 this.add(grade);
		 this.add(inTime);
		 this.add(gradePut);
		 
		 //버튼
		 this.add(closeBtn);
		 this.add(deleteBtn);
	 
	 }
	
	
	
	 
	 
	 
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == closeBtn) {
			
			String tempClass = AdmMainFrame.watchPanel.getClass().getName().split("view.")[1];
			if(tempClass.equals("AdmUsingUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			if(tempClass.equals("AdmAllUserList")) {
				new ControlPanel().changeTablePanel2(mf, op, this, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));				
			}
			
		}
		
		if(e.getSource() == deleteBtn) {
			System.out.println("AdmUserInfo : 회원삭제버튼클릭");
		}
	}
	
	
	
	

}
