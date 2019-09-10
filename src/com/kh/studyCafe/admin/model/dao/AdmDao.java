package com.kh.studyCafe.admin.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

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
			result++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int admWrite(ArrayList<User> user) {
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
					admWrite(userList); // 
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return userList;
	}
	// 좌석번호 수정
	public ArrayList<User> admLineSeat(String phoneNum, String seatNum){
		ArrayList<User> userList = null;

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setSeatNum(seatNum);
//					System.out.println(userList);
					//admWrite(userList); // 
//					System.out.println(userList + "2");
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return userList;
	}

	public ArrayList<User> admExitSeat(String phoneNum){
		ArrayList<User> userList = null;

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setInTime(0);
					userList.get(i).setOutTime(0);
					userList.get(i).setRemainTime(0);
//					System.out.println(userList);
					admWrite(userList); // 
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return userList;
	}

	public String toEnterInfo(String phoneNum) { 
		String seatNum = "0";
		ArrayList<User> userList = null;

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			System.out.println(userList);
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					
					seatNum = userList.get(i).getSeatNum();
					System.out.println("111seatNum"+seatNum);
				break;
				}
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		

		return seatNum;
	}

	public ArrayList<User> admEnterSeat(String phoneNum) {
		long inTime = 0;
		ArrayList<User> userList = null;
	    long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
//	    System.out.println(timeNow);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) 
					userList.get(i).setInTime(timeNow);
				break;
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return userList;
	}

	public ArrayList<User> admEnterSeatIndv(String phoneNum, int term, String seatNum) {
		long inTime = 0;
		ArrayList<User> userList = null;
	    long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
//	    System.out.println(timeNow);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum))
					userList.get(i).setSeatNum(seatNum);
					userList.get(i).setInTime(timeNow);
					userList.get(i).setOutTime(timeNow + term*3600000); 
					userList.get(i).setRemainTime(userList.get(i).getOutTime() - timeNow);
				break;
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return userList;
	}

	public ArrayList<User> admEnterSeat() { // 잔여시간을 현재시간 기준으로 변경하는 메소드
		long inTime = 0;
		ArrayList<User> userList = null;
	    long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
//	    System.out.println(timeNow);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			
			for (int i = 0; i < userList.size(); i++) {

				long remainTime = userList.get(i).getOutTime() - timeNow;
				
				if(userList.get(i).getInTime() != 0) {
					userList.get(i).setRemainTime(remainTime);
				}
				
				
				if(remainTime < 0) { // 퇴실 시간 지난 사람 퇴실 처리
					userList.get(i).setSeatNum("0");
					userList.get(i).setInTime(0);
					userList.get(i).setOutTime(0);
					userList.get(i).setRemainTime(0);
					userList.get(i).setSeatType(User.NOSEAT);
				}
			}
			
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("admEnterSeat 오류");
		}
		
		return userList;
	}
	

	   public ArrayList<User> admWeekReadLine(String phoneNum, int term){
	      ArrayList<User> userList = null;

	      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
	         userList = (ArrayList<User>) ois.readObject();

	         for (int i = 0; i < userList.size(); i++) {
	            if(userList.get(i).getPhoneNum().equals(phoneNum)) {
	               userList.get(i).setOutTime(userList.get(i).getOutTime() + term*86400000);
	               userList.get(i).setRemainTime(userList.get(i).getRemainTime() + term*86400000);
	               admWrite(userList); // 
	            }
	         }

	      } catch (ClassNotFoundException | IOException e) {
	         System.out.println("user.dat에 첫번째 입력");
	      }

	      return userList;
	   }
	   
   public User toUserInfo(String phoneNum) { 
        ArrayList<User> userList = null;
        User u = null;
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
           userList = (ArrayList<User>) ois.readObject();

           for (int i = 0; i < userList.size(); i++) {
              if(userList.get(i).getPhoneNum().equals(phoneNum)) {
                 u = (User) userList.get(i);
              }
           }
           
        }catch (ClassNotFoundException | IOException e) {
           System.out.println("user.dat에 첫번째 입력");
        }
        
        return u;

     }

}
















