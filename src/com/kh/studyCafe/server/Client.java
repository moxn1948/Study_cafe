package com.kh.studyCafe.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.kh.studyCafe.model.vo.User;

public class Client {
	
	public static void main(String[] args) {
			String serverIp;
			try {
				serverIp = InetAddress.getLocalHost().getHostAddress();
				Socket socket = new Socket(serverIp, Server.SERVER_PORT);
				
				// 서버로 출력할 출력처리용 객체
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				// 네크워크로 전송할 객체
				User u = new User("1홍길동", "010-1234-5678", "pass01");
				
				// 서버로 전송하기 위해 버퍼에 저장
				oos.writeObject(u);
				
				oos.flush();
				
				socket.close();
				oos.close();
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("통신 종료");
			
	}
	
}
