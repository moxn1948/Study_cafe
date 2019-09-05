package com.kh.studyCafe.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	/**
	 * 다수의 클라이언트가 접속하여 계속 통신하는 서버 프로그램 step 1. Server Socket 2. while loop에서
	 * accept()하여 소켓 반환받는다. 3. 소켓을 할당하는 ServerThread를 생성 4. start()
	 */
	public void go() throws IOException {
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(8500);
			System.out.println("**서버 실행**");
			// 다수의 클라이언트와 통신하기 위해 loop
			while (true) {
				s = ss.accept(); // 클라이언트 접속시 새로운 소켓이 리턴
				ServerThread st = new ServerThread(s);
				st.start();
				System.out.println(s.getInetAddress() + "님 입장");
			}
		} finally {
			if (s != null)
				s.close();
			if (ss != null)
				ss.close();
			System.out.println("**서버 종료**");
		}
	}

	public static void main(String[] args) {
		TestServer ts = new TestServer();
		try {
			ts.go();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
