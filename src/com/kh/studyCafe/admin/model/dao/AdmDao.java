package com.kh.studyCafe.admin.model.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.kh.studyCafe.admin.model.vo.AdmCafe;
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
					userList.get(i).setOutTime(userList.get(i).getOutTime() + term*3600000L);
					userList.get(i).setRemainTime(userList.get(i).getRemainTime() + term*3600000L);
					userList.get(i).setPointTime(userList.get(i).getPointTime() + term*3600000L);

					// 회원 등급 체크
					if (userList.get(i).getPointTime() > 360000000L) {
						userList.get(i).setRank("gold");
					} else if (userList.get(i).getPointTime() > 180000000L) {
						userList.get(i).setRank("silver");
					} else {
						userList.get(i).setRank("bronze");
					}

					
					admWrite(userList);
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
					userList.get(i).setSeatNum("0");
					userList.get(i).setSeatType(User.NOSEAT);
				
					admWrite(userList); // 
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return userList;
	}

	public ArrayList<User> admExitSeatWeek(String phoneNum){
		ArrayList<User> userList = null;

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setInTime(0);
					admWrite(userList); // 
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return userList;
	}

	public ArrayList<User> admRefundSeat(String phoneNum) {
		ArrayList<User> userList = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setInTime(0);
					userList.get(i).setOutTime(0);
					userList.get(i).setRemainTime(0);
					userList.get(i).setSeatNum("0");
					userList.get(i).setSeatType(User.NOSEAT);

					userList.get(i).setPointTime(userList.get(i).getPointTime() - userList.get(i).getRemainTime());

					if (userList.get(i).getPointTime() > 360000000L) {
						userList.get(i).setRank("gold");
					} else if (userList.get(i).getPointTime() > 180000000L) {
						userList.get(i).setRank("silver");
					} else {
						userList.get(i).setRank("bronze");
					}

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
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setInTime(timeNow);
					break;
				}
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return userList;
	}

	public ArrayList<User> admEnterSeatIndvTime(String phoneNum, int term, String seatNum) {

		ArrayList<User> userList = null;
		long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			System.out.println("userList.size : " + userList.size());
			System.out.println("phone : " + phoneNum);
			System.out.println("term + " + term);
			System.out.println("seatNum" + seatNum);
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setSeatNum(seatNum);
					userList.get(i).setInTime(timeNow);
					userList.get(i).setOutTime(timeNow + term*3600000L); 
					userList.get(i).setRemainTime(userList.get(i).getOutTime() - timeNow);
					userList.get(i).setSeatType(User.HOURSEAT);
					userList.get(i).setPointTime(userList.get(i).getPointTime() + term*3600000L);

					// 회원 등급 체크
					if (userList.get(i).getPointTime() > 360000000L) {
						userList.get(i).setRank("gold");
					} else if (userList.get(i).getPointTime() > 180000000L) {
						userList.get(i).setRank("silver");
					} else {
						userList.get(i).setRank("bronze");
					}


					break;
				}
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return userList;
	}

	public ArrayList<User> admEnterSeatGrp(String phoneNum, int term,int count, String seatNum) {

		ArrayList<User> userList = null;
		long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			System.out.println("userList.size : " + userList.size());
			System.out.println("phone : " + phoneNum);
			System.out.println("term + " + term);
			System.out.println("seatNum" + seatNum);
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setSeatNum(seatNum);
					userList.get(i).setInTime(timeNow);
					userList.get(i).setOutTime(timeNow + term*3600000L); 
					userList.get(i).setRemainTime(userList.get(i).getOutTime() - timeNow);
					userList.get(i).setSeatType(User.HOURSEAT);
					userList.get(i).setPointTime(userList.get(i).getPointTime() + term*3600000L);
					
					// 회원 등급 체크
					if(userList.get(i).getPointTime() > 360000000L) {
						userList.get(i).setRank("gold");
					}else if(userList.get(i).getPointTime() > 180000000L) {
						userList.get(i).setRank("silver");
					}else {
						userList.get(i).setRank("bronze");
					}


					break;
				}
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return userList;
	}

	public ArrayList<User> admEnterSeatIndvWeek(String phoneNum, int weekTerm, String seatNum) {
		long inTime = 0;
		ArrayList<User> userList = null;
		long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
		//	    System.out.println(timeNow);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					userList.get(i).setSeatNum(seatNum);
					userList.get(i).setInTime(timeNow);
					userList.get(i).setOutTime(timeNow + weekTerm*3600000L*24L); 
					userList.get(i).setRemainTime(userList.get(i).getOutTime() - timeNow);
					userList.get(i).setSeatType(User.WEEKSEAT);
					userList.get(i).setPointTime(userList.get(i).getPointTime() + weekTerm*3600000L*24L);
					
					// 회원 등급 체크
					if (userList.get(i).getPointTime() > 360000000L) {
						userList.get(i).setRank("gold");
					} else if (userList.get(i).getPointTime() > 180000000L) {
						userList.get(i).setRank("silver");
					} else {
						userList.get(i).setRank("bronze");
					}

					break;
				}
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
		//		       System.out.println(timeNow);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();


			for (int i = 0; i < userList.size(); i++) {

				long remainTime = userList.get(i).getOutTime() - timeNow;

				if(userList.get(i).getRemainTime() != 0) {
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
					userList.get(i).setOutTime(userList.get(i).getOutTime() + term*86400000L);
					userList.get(i).setRemainTime(userList.get(i).getRemainTime() + term*86400000L);
					userList.get(i).setPointTime(userList.get(i).getPointTime() + term*86400000L);

					// 회원 등급 체크
					if (userList.get(i).getPointTime() > 360000000L) {
						userList.get(i).setRank("gold");
					} else if (userList.get(i).getPointTime() > 180000000L) {
						userList.get(i).setRank("silver");
					} else {
						userList.get(i).setRank("bronze");
					}

					
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


	//로그인 아이디 패스워트 텍스트 불러오기
	public String loginInforRead() {
		String idPwd="";
		File file =new File("loginfo.txt");

		try {
			BufferedReader inFiles = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsoluteFile()),"UTF8"));
			String line ="";
			while((line=inFiles.readLine())!=null) {
				if(line.trim().length()>0) {
					idPwd+=line+",";
				}
			}
			inFiles.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return idPwd;

	}

	//카페정보 불러오기 메소드 객체씀
	public void writeCafe() {
		FileOutputStream fos =null;
		ObjectOutputStream oos = null;
		
		AdmCafe ac = new AdmCafe(0,1,2);
		
		try {
			fos= new FileOutputStream("CafeInfo.dat");
			oos=new ObjectOutputStream(fos);
			
			oos.writeObject(ac);
			
			System.out.println("객체를 저장했습니다.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	

   	public AdmCafe readCafe() {
   		FileInputStream fis =null;
   		ObjectInputStream ois =null;
   		AdmCafe ac = null;
   		
   		try {
   			//cafeInfo파일로 부터 객체를 읽어오는 스트림 생성
			fis= new FileInputStream("CafeInfo.dat");
			ois= new ObjectInputStream(fis);
			
			//CafeINfo로 부터 객체 하나씩 읽어서 출력
			ac = (AdmCafe) ois.readObject();
//			int daysale = ac.getTotalDaySales();
			
//			System.out.println("fffffff");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
   		
   		return ac;
   	}
	
	

	// 회원삭제 메소드
	public int admDeleteUserWrite(User u) {
		int result = 0;

		ArrayList<User> uTemp = admRead();
		if(uTemp == null) {
			uTemp = new ArrayList<User> ();
		}

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			for (int i = 0; i < uTemp.size(); i++) {
				if(u.getPhoneNum().equals(uTemp.get(i).getPhoneNum())) {
					uTemp.remove(i);
				}
			}
			oos.writeObject(uTemp);

			oos.flush();
			result++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
















