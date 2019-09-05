package com.kh.studyCafe.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	/**
	 * step 1. Socket 생성 2. BufferedReader - InputStreamReader - System.in 3.
	 * PrintWriter - s.getOutputStream() 4. BufferedReader - InputStreamReader -
	 * s.getInputStream() 5. while - 콘솔에서 readLine() 서버로 println() 서버에서 보낸 데이터를
	 * readLine() 6. close()
	 */
	public void go() throws UnknownHostException, IOException {
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		BufferedReader br2 = null;
		try {
			s = new Socket("127.0.0.1", 8500);
			// s = new Socket("192.168.0.108", 5432);
			System.out.println("**서버 연결 OK**");
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str;

			while (true) {
				System.out.print("서버에 보낼 메시지:");
				str = br.readLine();
				if (str.equalsIgnoreCase("exit"))
					break;
				pw.println(str);

				System.out.println("서버로 부터 받은 메시지: " + br2.readLine());
			}
		} finally {
			if (br2 != null)
				br2.close();
			if (pw != null)
				pw.close();
			if (br != null)
				br.close();
			if (s != null)
				s.close();
			System.out.println("**연결 종료**");
		}

	}

	public static void main(String[] args) {
		TestClient tc = new TestClient();
		try {
			tc.go();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
