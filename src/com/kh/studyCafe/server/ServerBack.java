package com.kh.studyCafe.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.model.vo.User;

public class ServerBack{
	private ServerSocket serverSocket;
	private Socket socket;
	// 사용자의 정보 저장하는 맵
	private static Map<Object, ObjectOutputStream> clientsMap = new HashMap<Object, ObjectOutputStream>();
	private ArrayList<User> user;
//	private Iterator<Object> it;
	
	public void setting() { // 완료
		Collections.synchronizedMap(clientsMap); // 클라이언트 접속 시 교통정리
		
		try {
			serverSocket = new ServerSocket(8000); // 서버 소켓 생성
			
			while(true) {
				// 서버가 하는 일 : 클라이언트 접속 받음
				System.out.println("서버 대기 중");
				
				socket = serverSocket.accept(); // 서버 소켓에 접속한 클라이언트를 소켓에 저장
//				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				
				// 클라이언트 쓰레드 클래스 생성해서 접속한 클라이언트 소켓 정보 넣어줌
				Receiver receiver = new Receiver(socket);
				receiver.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) { // 완료
		new ServerBack().setting(); // 서버 실행
	}

	// 맵의내용(클라이언트) 저장과 삭제
	public void addClient(Object ipName, ObjectOutputStream out) throws IOException {
		clientsMap.put(ipName, out);
		System.out.println("사용자정보 저장 완료");
		System.out.println("clientMap : " + clientsMap.size());
		System.out.println("clientMap key : " + clientsMap.keySet());
		System.out.println("clientMap value : " + clientsMap.get(ipName));
	}

	public void removeClient(Object ipName) {
		clientsMap.remove(ipName);
	}

	// user 내용 전파
	public void sendMessage(ArrayList<User> user) {
		Iterator<Object> it = clientsMap.keySet().iterator();
		Object key = null;
		System.out.println("it0 : " + it);
		System.out.println("clientsMap" + clientsMap.size());
		while (it.hasNext()) {
			System.out.println("it2 : " + it);
			key = it.next();
			System.out.println("1key : " + key);
			try {
				System.out.println("2key : " + key);
				clientsMap.get(key).writeObject(user);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
