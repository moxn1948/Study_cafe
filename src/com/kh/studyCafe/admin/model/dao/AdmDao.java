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
			e.printStackTrace();
		}
		
		return userList;
	}

	public int admWrite(ArrayList<User> userList) {
		int result = 0;

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			
			oos.writeObject(userList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
