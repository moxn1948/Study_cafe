package com.kh.studyCafe.client;

import java.util.Date;
import java.util.GregorianCalendar;

import com.kh.studyCafe.admin.model.dao.AdmDao;

public class MinTimeThread extends Thread{
	private ClientBack client;
	
	public MinTimeThread(ClientBack client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		while(true) {
			
			// 메소드 : remainTime을 현재시간으로 수정하고 client.appendUser()

			try {
				Thread.sleep(5000); // 10초

				System.out.println("스레드 테스트");
				client.sendUser(new AdmDao().admEnterSeat());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
