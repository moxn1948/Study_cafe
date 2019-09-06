package com.kh.studyCafe.kosk.view;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.model.vo.User;
 
public class KoskMainFrame extends JFrame{
	public KoskMainFrame() {
		this.setSize(360,640);
		

		new KoskLogin(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 

	public void appendUser(ArrayList<User> user) {
		new AdmDao().admWrite(user);
	}

}
