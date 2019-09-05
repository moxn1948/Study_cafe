package com.kh.studyCafe.admin.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.studyCafe.model.vo.User;

public class AdmDao {

	public ArrayList<User> admRead(){
		ArrayList<User> userList = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		
		return userList;
	}

	public int admWrite(User u) {
		int result = 0;
		
		ArrayList<User> uTemp = admRead();
		if(uTemp == null) {
			uTemp = new ArrayList<User> ();
		}
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			uTemp.add(u);
			oos.writeObject(uTemp);
			
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
















