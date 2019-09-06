package com.kh.studyCafe.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.view.AdmMainFrame;
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.model.vo.User;

public class ClientBack {
	private JFrame mf;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private String ipName;
	private ArrayList<User> user;
	
	public final void setGui(AdmMainFrame admMf) { // admin 메인프레임 실행 시
		this.mf = admMf;
	}
	public final void setGui(KoskMainFrame koskMf) { // kosk 메인프레임 실행 시
		this.mf = koskMf;
	}

	public static void main(String[] args) {
		ClientBack clientBack = new ClientBack();
		clientBack.connect();
	}
	
	public void connect() {
		
		try {
			socket = new Socket("192.168.219.106", 8000);
			System.out.println("서버 연결됨");
			
			in = new ObjectInputStream(socket.getInputStream()); // 서버 측에서 전송 받음
			out = new ObjectOutputStream(socket.getOutputStream()); // 서버 측으로 전송
			
			out.writeUTF(ipName);
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendUser(ArrayList<User> user) {
		try {
			out.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setIpName(String ipName) {
		this.ipName = ipName;
	}

	
}
