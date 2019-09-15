package com.kh.studyCafe.client;

import com.kh.studyCafe.admin.model.dao.AdmDao;

public class MinTimeThread extends Thread{
	private ClientBack client;
	
	public MinTimeThread(ClientBack client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		while(true) {

			try {
				Thread.sleep(60000); // 1분

				System.out.println("스레드 동작");
				client.sendUser(new AdmDao().admEnterSeat());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
