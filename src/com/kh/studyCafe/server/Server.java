package com.kh.studyCafe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.model.vo.User;

public class Server {
	public final static int SERVER_PORT = 8500;
	
	public static void main(String[] args) {
		ServerSocket server; // client의 접속을 기다리는 역할
		Socket sock; // client와 데이터 송수신 역할 
		ObjectInputStream ois; // Class 객체를 읽어옴
		
		try {
			server = new ServerSocket(SERVER_PORT);
			
			// 무한 루틴
			while (true) {
				sock = server.accept();
				
				ois = new ObjectInputStream(sock.getInputStream());
				
				User u = (User) ois.readObject();
				
				AdmDao ad = new AdmDao();
//				ArrayList<User> user = new ArrayList<User> ();
//				user.add(u);
				ad.admWrite(u);
				
				System.out.println(ad.admRead().size());
				for (int i = 0; i < ad.admRead().size(); i++) {
					System.out.println("abc : " + ad.admRead().get(i));
				}
				
				
				sock.close();
				ois.close();
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
