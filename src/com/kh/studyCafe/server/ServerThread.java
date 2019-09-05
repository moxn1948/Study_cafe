package com.kh.studyCafe.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 개별 클라이언트와 메세지를 주고 받는 스레드 Socket: 멤버변수, 생성자를 통해서 TestServer에서 할당 받는다. 1.
 * extends Thread 2. run() 클라이언트의 메세지를 주고 받는 비즈니스(Socket)
 * 
 * @author 관리자
 *
 */
public class ServerThread extends Thread {
	// 멤버변수로 선언
	private Socket socket;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private String userIP;

	ServerThread(Socket s) {
		this.socket = s;
		userIP = socket.getInetAddress().toString();
	}

	// 오버라이딩일 경우 throw 불가.
	public void run() {
		try {
			service();
		} catch (IOException e) {
			System.out.println("**" + userIP + "님 접속 종료.");
		} finally {
			try {
				closeAll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void service() throws IOException {
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream(), true);
		String str = null;
		while (true) {
			str = br.readLine();
			if (str == null) {
				System.out.println(userIP + "님이 연결을 종료했습니다.");
				break;
			}
			System.out.println(userIP + "님: " + str);
			pw.println(str);
		}
	}

	public void closeAll() throws IOException {
		if (pw != null)
			pw.close();
		if (br != null)
			br.close();
		if (socket != null)
			socket.close();
	}
}
