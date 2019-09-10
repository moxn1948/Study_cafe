package com.kh.studyCafe.kosk.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.kh.studyCafe.model.vo.User;

public class KoskDao {

	

	

	public int KoskWrite(ArrayList<User> user) {
		int result = 0;

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			oos.writeObject(user);

			oos.flush();
			result++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 1일권 잔여시간 수정
	public ArrayList<User> admReadLine(String phoneNum, int term){
		ArrayList<User> userList = null;

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setOutTime(userList.get(i).getOutTime() + term*3600000);
					userList.get(i).setRemainTime(userList.get(i).getRemainTime() + term*3600000);
					KoskWrite(userList); // 
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return userList;
	}
	// 좌석번호 수정
	
    // ==== 퇴시 =====
	

	public String toEnterInfo(String phoneNum) { 
		String seatNum = null;
		ArrayList<User> userList = null;

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) 
					seatNum = userList.get(i).getSeatNum();
				break;
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return seatNum;
	}

	public ArrayList<User> admEnterSeat(String phoneNum) { // 입실 시간을 바꾸는 메소드, 특정인의 입실시간을 바꿀거지 => 핸드폰번호 => admEnterSeat("010-1414-13")
		long inTime = 0;
		ArrayList<User> userList = null;
		
	    long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime(); // 현재시간을 저장 long 타입
	    System.out.println(timeNow);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject(); // 파일 읽어오고
			
			for (int i = 0; i < userList.size(); i++) { // 회원 수 만큼 for
				if(userList.get(i).getPhoneNum().equals(phoneNum))  // i번째 핸드폰 번호랑 우리가 가져온 핸드폰 번호 비교
					userList.get(i).setInTime(timeNow); // i번째 회원의 입실시간을 변경 => 현재시간으로 변경
				break;
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return userList;
	}
	
	public ArrayList<String> seatin(){
		
		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if(!userList.get(i).getSeatNum().equals("0")) {
					seatnum.add(userList.get(i).getSeatNum());
				}
				System.out.println(userList.get(i));
				
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		
		
		return seatnum;
		
	}
	public int login(String phonenumber, String password) { 
		
		
		//this.phonenumber = phonenumber;
		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;
		
		int a = 0 ;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phonenumber)) {
					if(userList.get(i).getPassword().equals(password)) {
						if(!userList.get(i).getSeatNum().equals("0")) {
							a = 1; // 회원정보 있으면서 좌석까지 있음
						} else {
							a = 2; // 회원정보 있으나 좌석이 없음
						}
					} else {
					}
				}
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return a;
	}
	
	/*public int KoskWrite(User u) {
		int result = 0;

		ArrayList<User> uTemp = KoskRead();
		if(uTemp == null) {
			uTemp = new ArrayList<User> ();
		}

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			uTemp.add(u);
			oos.writeObject(uTemp);

			oos.flush();
			result++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}*/
	//== 시트 저장 ==
		public ArrayList<User> KoskLineSeat(String phoneNum, String seatNum){
			ArrayList<User> userList = null;

			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();

				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						userList.get(i).setSeatNum(seatNum);
						System.out.println(userList);
						KoskWrite(userList); // 
						System.out.println(userList + "2");
					}
				}

			} catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}

			return userList;
		}
		public String Koskmove(String phonenumber){
			ArrayList<User> userList = null;
			String user = new String();
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();

				
				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phonenumber)) {
						user = (userList.get(i).toString());
						
					}
				}
				System.out.println(user);

			} catch (Exception e) {
				System.out.println("user.dat에 첫번째 입력");
			} 
			
			return user;
		}
		
		
		/*public ArrayList<User> KoskReadseat(){
			ArrayList<User> userList = null;
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();
					
				userList.get(0).getSeatNum();
				
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}

			return userList;
		}*/
		public ArrayList<User> KoskExitSeat(String phoneNum){
			ArrayList<User> userList = null;

			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();

				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						userList.get(i).setInTime(0);
						userList.get(i).setSeatNum("0");
						userList.get(i).setOutTime(0);
						userList.get(i).setRemainTime(0);
						System.out.println(userList);
						KoskWrite(userList); // 
					} else {
						System.out.println(userList.get(i).getPhoneNum());
						System.out.println(phoneNum+"폰넘버");
						System.out.println("실패");
					}
				}

			} catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}

			return userList;
		}

}















