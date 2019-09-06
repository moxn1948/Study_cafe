package com.kh.studyCafe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.kh.studyCafe.model.vo.User;

// 서버 측 리시버
// 서버 측에 접속한 클라이언트 소켓 정보를 넣어줌
public class Receiver extends Thread {
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private String ipName;
	
	private ArrayList<User> user;
	private ServerBack serverBack = new ServerBack();

	public Receiver(Socket socket) throws IOException {
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
		ipName = in.readUTF(); // 스트림에 있는 값을 읽어옴
		serverBack.addClient(ipName, out);	
		
	}

	public void run() {
		try {
			while (in != null) {
				user = (ArrayList<User>) in.readObject();
				serverBack.sendMessage(user);
			}
		} catch (IOException | ClassNotFoundException e) {
			// 접속 종료시 해당 클라이언트 삭제
			System.out.println("ddddd");
			serverBack.removeClient(ipName);
		}
	}
	
}
