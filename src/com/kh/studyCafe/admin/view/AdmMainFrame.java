package com.kh.studyCafe.admin.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmCafe;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;


public class AdmMainFrame extends JFrame implements ActionListener{
	private ClientBack client = new ClientBack(); // 클라이언트 백그라운드 생성
	private static Object ipName;
	public static JPanel watchPanel = null;
	private AdmDao ad = new AdmDao();
	private AdmCafe ac = ad.readCafe();
	
	// 메인 프레임
	public AdmMainFrame() {
		this.setBounds(0, 0, 978, 700); 
		this.setLayout(null);
		
		new AdmLoginMain(this, client); // 프로그램 실행 시 첫번째 페이지
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		ad.admEnterSeat();
		
		Calendar cal = Calendar.getInstance();
		if(ac.getDay() != cal.get(cal.DATE)) {
			ac.setDay(cal.get(cal.DATE));
			ac.setTotalDaySales(0);
			ad.writeCafe(ac);
		}
		
		try {
			ipName = InetAddress.getLocalHost().getHostAddress();
			client.setGui(this);
			client.setIpName(ipName);
			client.connect();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

	
	public void appendUser(ArrayList<User> user) {
		// 클라이언트 측 리페인트
		ad.admWrite(user); // 새파일 생성해야 함
		
		ArrayList<User> userList = ad.admRead();
		
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getTotalSales() != 0) {
				int Sales = userList.get(i).getTotalSales();
				ac.setTotalDaySales(ac.getTotalDaySales() + Sales);
				ac.setTotalMonthSales(ac.getTotalDaySales());
				userList.get(i).setTotalSales(0);
			}
		}
		
		ac.setTotalUserAmount(userList.size());
		ad.writeCafe(ac);
		ad.admWrite(userList);
		
		System.out.println("리페인트 타이밍");
		
		String tempWatch = AdmMainFrame.watchPanel.getClass() + "";
		if(!tempWatch.substring(tempWatch.length() - 6, tempWatch.length()).equals("JPanel")) {
			this.remove(AdmMainFrame.watchPanel);
			String tempClass = AdmMainFrame.watchPanel.getClass().getName().split("view.")[1];
			if(tempClass.equals("AdmUsingUserList")) {
				this.add(new AdmUsingUserList(this, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));
			}else if(tempClass.equals("AdmAllUserList")) {
				this.add(new AdmAllUserList(this, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));
			}
		}
		
		this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
}
