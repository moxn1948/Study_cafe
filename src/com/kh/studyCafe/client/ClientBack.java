package com.kh.studyCafe.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.kh.studyCafe.admin.view.AdmMainFrame;
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.model.vo.User;

public class ClientBack {
	private JFrame mf;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Object ipName;
	private ArrayList<User> user;
	
	public final void setGui(AdmMainFrame admMf) { // admin 메인프레임 실행 시
//		System.out.println("admin mainFrame");
		this.mf = admMf;
	}
	public final void setGui(KoskMainFrame koskMf) { // kosk 메인프레임 실행 시
//		System.out.println("Kosk mainFrame");
		this.mf = koskMf;
	}

	public static void main(String[] args) {
		ClientBack clientBack = new ClientBack();
		clientBack.connect();
	}
	
	public void connect() {
		
		try {
			socket = new Socket("192.168.1.157", 8000);
			System.out.println("서버 연결됨");
			
			in = new ObjectInputStream(socket.getInputStream()); // 서버 측에서 전송 받음
			out = new ObjectOutputStream(socket.getOutputStream()); // 서버 측으로 전송
			
			out.writeObject(ipName);
			
			System.out.println("클라이언트 : 메시지 전송완료");
			
			while(in!=null) {
				user = (ArrayList<User>) in.readObject();
				if(mf instanceof AdmMainFrame) {
					((AdmMainFrame) mf).appendUser(user);
				}else if(mf instanceof KoskMainFrame){
					((KoskMainFrame) mf).appendUser(user);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendUser(ArrayList<User> user) {
		try {
			out.writeObject(user); // 클라이언트 스트림에 변경된 파일 올라가있음
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setIpName(Object ipName) {
		this.ipName = ipName;
	}

	
}
