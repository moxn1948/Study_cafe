package com.kh.studyCafe.kosk.view;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.view.AdmMainFrame;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;
 
public class KoskMainFrame extends JFrame{
	// 네트워크 코드
	private ClientBack client = new ClientBack();
	private static Object ipName;
	public static JPanel koskWatchPanel;
	
	public KoskMainFrame() {
		this.setSize(360,640);
		this.setLayout(null);

		new KoskLogin(this, client);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// 네트워크 코드
		try {
			ipName = InetAddress.getLocalHost().getHostAddress();
			client.setGui(this);
			client.setIpName(ipName);
			client.connect();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	} 

	// 네트워크 코드
	public void appendUser(ArrayList<User> user) {
		// 클라이언트 측 리페인트
		new AdmDao().admWrite(user); // 새파일 생성해야 함
		System.out.println("리페인트 타이밍");
		
		
		if(KoskMainFrame.koskWatchPanel != null) {
				
			String tempClass = KoskMainFrame.koskWatchPanel.getClass().getName().split("view.")[1];
			if(tempClass.equals("KoskSeatTable")) {
				
				this.remove(KoskMainFrame.koskWatchPanel);
				this.add(new KoskSeatTable(this, KoskSeatTable.phoneNum, client));
				this.repaint();
				System.out.println("리페인트 수정됨2");
			}
			
//			System.out.println(new AdmDao().admRead());
			System.out.println("리페인트 수정됨");
		}
		
	}

}
