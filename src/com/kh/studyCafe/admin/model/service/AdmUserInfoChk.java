package com.kh.studyCafe.admin.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.model.vo.User;

public class AdmUserInfoChk {
	
	public ArrayList<AdmUserTable> usingUserInfo(ArrayList<User> u){
		// 데이터 가공
		ArrayList<User> user = new ArrayList<User> ();
		
		for (int i = 0; i < u.size(); i++) {
			if(u.get(i).getInTime() != 0) {
				user.add(u.get(i));
			}
		}
		
		String[] name = new String[user.size()];
		String[] phoneNum = new String[user.size()];
		String[] seatNum = new String[user.size()];
		long[] inTime = new long[user.size()];
		long[] outTime = new long[user.size()];
		long[] remainTime = new long[user.size()];
		String[] seatType = new String[user.size()];
		
		ArrayList<AdmUserTable> utList = new ArrayList<AdmUserTable> ();


		for (int i = 0; i < user.size(); i++) {
			name[i] = u.get(i).getName();
			phoneNum[i] = u.get(i).getPhoneNum();
			seatNum[i] = u.get(i).getSeatNum();
			inTime[i] = u.get(i).getInTime();
			outTime[i] = u.get(i).getOutTime();
			remainTime[i] = u.get(i).getRemainTime();
			
			if(seatNum[i].contains("-")) {
				seatType[i] = "그룹";
			}else {
				seatType[i] = "개인";
			}
			
			AdmUserTable ut = new AdmUserTable(name[i], phoneNum[i], seatNum[i], inTime[i], outTime[i], remainTime[i], seatType[i]);
			
			utList.add(ut);
			
		}
		
		// 정렬코드 추가
		
		return utList;
	}

public void infoWrite() {
//	ArrayList<User> userList = new ArrayList<User> ();

	long inTime = new Date(new GregorianCalendar(2019, 8, 4, 0, 0, 0).getTimeInMillis()).getTime();
	
	long outTime = new Date(new GregorianCalendar(2019, 8, 4, 23, 0, 0).getTimeInMillis()).getTime();
	long outTime2 = new Date(new GregorianCalendar(2019, 8, 10, 3, 0, 0).getTimeInMillis()).getTime();
	long currentTime = new Date().getTime();
	
	
	long remainTime = outTime - currentTime;
	long remainTime2 = outTime2 - currentTime;
	long pointTime = outTime - inTime;
	long pointTime2 = outTime2 - inTime;
	
	User u = new User("별님", "010-1111-2222", "pass123", "4-A", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime, "silver");
	User u1 = new User("달님그룹", "010-1221-2222", "pass4", "1", inTime, outTime2, remainTime2, User.NOSEAT, 1000, pointTime2, "gold");
	User u2 = new User("햇님", "010-1331-2222", "pass523", "6-A", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime, "silver");
	User u3 = new User("팥쥐", "010-1441-2222", "pass623", "12", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime, "silver");
	User u4 = new User("콩쥐", "010-1551-2222", "pass723", "0", 0, 0, 0, User.NOSEAT, 0, 0, "bronze");
	
/*	userList.add(u);
	userList.add(u1);
	userList.add(u2);
	userList.add(u3);
	userList.add(u4);*/
	
//	return userList;
	
	AdmDao ad = new AdmDao();
	ad.admWrite(u);
	ad.admWrite(u1);
	ad.admWrite(u2);
	ad.admWrite(u3);
	ad.admWrite(u4);
}

}



	/*
	 * 
	 * 


	public void infoWrite() {
		ArrayList<User> userList = new ArrayList<User> ();

		long inTime = new Date(new GregorianCalendar(2019, 8, 4, 0, 0, 0).getTimeInMillis()).getTime();
		long outTime = new Date(new GregorianCalendar(2019, 8, 4, 3, 0, 0).getTimeInMillis()).getTime();
		long currentTime = new Date().getTime();
		long remainTime = outTime - currentTime;
		long pointTime = outTime - inTime;
		
		User u = new User("김진호", "010-1111-2222", "pass123", "4-A", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime, "silver");
		User u1 = new User("김진호1", "010-1221-2222", "pass4", "8-A", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime, "silver");
		User u2 = new User("김진호2", "010-1331-2222", "pass523", "6-A", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime, "silver");
		User u3 = new User("김진호3", "010-1441-2222", "pass623", "12", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime, "silver");
		User u4 = new User("김진호4", "010-1551-2222", "pass723", "0", 0, 0, 0, User.NOSEAT, 0, 0, "bronze");
		
		userList.add(u);
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		
//		return userList;
		
		AdmDao ad = new AdmDao();
		ad.admWrite(userList);
	}
	
	public void infoRead() {
		AdmDao ad = new AdmDao();
		for (int i = 0; i < ad.admRead().size(); i++) {
			System.out.println(ad.admRead().get(i));
		}
		
		
	}*/
	
