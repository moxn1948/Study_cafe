package com.kh.studyCafe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.model.vo.User;

// 서버 측 리시버
// 서버 측에 접속한 클라이언트 소켓 정보를 넣어줌
public class Receiver extends Thread {
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Object ipName;
	
	private ArrayList<User> user;
	private ServerBack serverBack = new ServerBack();

	public Receiver(Socket socket) throws IOException {
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
		
		try {
			ipName = in.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		// 스트림에 있는 값을 읽어옴
		System.out.println("receiver class");
		serverBack.addClient(ipName, out);	
		
	}

	public void run() {
		try {
			while (in != null) {
				user = (ArrayList<User>) in.readObject();
				new AdmDao().admWrite(user);
				serverBack.sendMessage(user);
				
//				System.out.println("Receiver : " + user);
				// 모든 클라이언트 리페인트 구문
			}
		} catch (IOException | ClassNotFoundException e) {
			// 접속 종료시 해당 클라이언트 삭제
			System.out.println(ipName +"종료");
			serverBack.removeClient(ipName);
		}
	}
	
}
