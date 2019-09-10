package com.kh.studyCafe.admin.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.kh.studyCafe.admin.model.comparator.AscendingName;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.model.vo.User;

public class AdmUserInfoChk {


	   public ArrayList<AdmUserTable> usingUserInfo(ArrayList<User> u) {

	      // 이용중인 회원 데이터 가공
	      ArrayList<User> user = new ArrayList<User>();

	      for (int i = 0; i < u.size(); i++) {
	         if (u.get(i).getInTime() != 0) {
	            user.add(u.get(i));
	         }
	      }

	      /*for (int i = 0; i < user.size(); i++) {
	         System.out.println(user.get(i));
	      }*/

	      String[] name = new String[user.size()];
	      String[] phoneNum = new String[user.size()];
	      String[] seatNum = new String[user.size()];
	      long[] inTime = new long[user.size()];
	      long[] outTime = new long[user.size()];
	      long[] remainTime = new long[user.size()];
	      int[] seatType = new int[user.size()];

	      ArrayList<AdmUserTable> utList = new ArrayList<AdmUserTable>();

	      for (int i = 0; i < user.size(); i++) {
	         name[i] = user.get(i).getName();
	         phoneNum[i] = user.get(i).getPhoneNum();
	         seatNum[i] = user.get(i).getSeatNum();
	         inTime[i] = user.get(i).getInTime();
	         outTime[i] = user.get(i).getOutTime();
	         remainTime[i] = user.get(i).getRemainTime();
	         seatType[i] = user.get(i).getSeatType();


	         AdmUserTable ut = new AdmUserTable(name[i], phoneNum[i], seatNum[i], inTime[i], outTime[i], remainTime[i],
	               seatType[i]);

	         utList.add(ut);

	      }

	      // 이름순 정렬
	      utList.sort(new AscendingName());

	      return utList;
	   }

	   // 전체 회원 리스트에 맞게 데이터 가공
	   public ArrayList<AdmUserTable> AllUserInfo(ArrayList<User> u) {

	   
	      // 데이터 가공
	      ArrayList<User> user = new ArrayList<User>();
	      for (int i = 0; i < u.size(); i++) {
	         if (u.get(i).getInTime() == 0) {
	            user.add(u.get(i));
	         }
	      }
	      
	      String[] name = new String[user.size()];
	      String[] phoneNum = new String[user.size()];
	      String[] seatNum = new String[user.size()];
	      long[] inTime = new long[user.size()];
	      long[] outTime = new long[user.size()];
	      long[] remainTime = new long[user.size()];
	      int[] seatType = new int[user.size()];

	      ArrayList<AdmUserTable> utList = new ArrayList<AdmUserTable>();

	      for (int i = 0; i < user.size(); i++) {
	         name[i] = user.get(i).getName();
	         phoneNum[i] = user.get(i).getPhoneNum();
	         seatNum[i] = user.get(i).getSeatNum();
	         inTime[i] = user.get(i).getInTime();
	         outTime[i] = user.get(i).getOutTime();
	         remainTime[i] = user.get(i).getRemainTime();
	         seatType[i] = user.get(i).getSeatType();

	         AdmUserTable ut = new AdmUserTable(name[i], phoneNum[i], seatNum[i], inTime[i], outTime[i], remainTime[i],
	               seatType[i]);

	         utList.add(ut);

	      }

	      // 이름순 정렬
	      utList.sort(new AscendingName());
	      return utList;
	   }
	
	/*
	 * public String toPhoneInfo(String phoneNum, ArrayList<User> u) { // 전화번호로 이름
	 * 찾는 서비스 String name = null; for (int i = 0; i < u.size(); i++) { if
	 * (u.get(i).getPhoneNum().equals(phoneNum)) { name = u.get(i).getName(); break;
	 * }
	 * 
	 * }
	 * 
	 * return name; }
	 */

	public long toRemainInfo(String phoneNum, ArrayList<User> u) { 
		long remainTime = 0L;
		for (int i = 0; i < u.size(); i++) {
			if (u.get(i).getPhoneNum().equals(phoneNum)) {
				remainTime = u.get(i).getRemainTime();
				break;
			}

		}

		return remainTime;
	}
	
	

	public void infoWrite() {
		// ArrayList<User> userList = new ArrayList<User> ();

	      long inTime = new Date(new GregorianCalendar(2019, 8, 10, 0, 22, 0).getTimeInMillis()).getTime();

	      long outTime = new Date(new GregorianCalendar(2019, 8, 10, 18, 0, 0).getTimeInMillis()).getTime();
	      long outTime3 = new Date(new GregorianCalendar(2019, 8, 10, 17, 0, 0).getTimeInMillis()).getTime();
	      long outTime2 = new Date(new GregorianCalendar(2019, 8, 13, 0, 0, 0).getTimeInMillis()).getTime();
	      long currentTime = new Date().getTime();

	      long remainTime = outTime - currentTime;
	      long remainTime2 = outTime2 - currentTime;
	      long remainTime3 = outTime3 - currentTime;
	      long pointTime = outTime - inTime;
	      long pointTime2 = outTime2 - inTime;
	      long pointTime3 = outTime3 - inTime;

	      User u = new User("별님", "010-1111-2211", "pass123", "4-A", inTime, outTime, remainTime, User.HOURSEAT, 1000, pointTime, "silver");
	      User u1 = new User("달님", "010-1121-2212", "pas24", "0", 0, 0, 0, User.NOSEAT, 1000, pointTime2, "gold");
	      User u2 = new User("햇님", "010-1131-2213", "pass323", "6-A", inTime, outTime3, remainTime3, User.HOURSEAT, 1000,   pointTime, "silver");
	      User u3 = new User("팥쥐", "010-1141-2214", "pass423", "11", inTime, outTime3, remainTime3, User.HOURSEAT, 1000, pointTime, "silver");
	      User u4 = new User("콩쥐", "010-1151-2215", "pass523", "12", 0, 0, remainTime2, User.WEEKSEAT, 0, pointTime2, "bronze");
	      User u5 = new User("대한", "010-1161-2214", "pass623", "22", inTime, outTime2, remainTime2, User.WEEKSEAT, 1000, pointTime, "silver");
	      User u6 = new User("민국", "010-1171-2214", "pass723", "13", inTime, outTime, remainTime, User.HOURSEAT, 1000, pointTime, "silver");
	      User u7 = new User("만세", "010-1181-2214", "pass823", "4", inTime, outTime, remainTime, User.HOURSEAT, 1000, pointTime, "silver");
	      
	      AdmDao ad = new AdmDao();
	      ad.admWrite(u);
	      ad.admWrite(u1);
	      ad.admWrite(u2);
	      ad.admWrite(u3);
	      ad.admWrite(u4);
	      ad.admWrite(u5);
	      ad.admWrite(u6);
	      ad.admWrite(u7);
	}

}

/*
 * 
 * 
 * 
 * 
 * public void infoWrite() { ArrayList<User> userList = new ArrayList<User> ();
 * 
 * long inTime = new Date(new GregorianCalendar(2019, 8, 4, 0, 0,
 * 0).getTimeInMillis()).getTime(); long outTime = new Date(new
 * GregorianCalendar(2019, 8, 4, 3, 0, 0).getTimeInMillis()).getTime(); long
 * currentTime = new Date().getTime(); long remainTime = outTime - currentTime;
 * long pointTime = outTime - inTime;
 * 
 * User u = new User("김진호", "010-1111-2222", "pass123", "4-A", inTime, outTime,
 * remainTime, User.NOSEAT, 1000, pointTime, "silver"); User u1 = new
 * User("김진호1", "010-1221-2222", "pass4", "8-A", inTime, outTime, remainTime,
 * User.NOSEAT, 1000, pointTime, "silver"); User u2 = new User("김진호2",
 * "010-1331-2222", "pass523", "6-A", inTime, outTime, remainTime, User.NOSEAT,
 * 1000, pointTime, "silver"); User u3 = new User("김진호3", "010-1441-2222",
 * "pass623", "12", inTime, outTime, remainTime, User.NOSEAT, 1000, pointTime,
 * "silver"); User u4 = new User("김진호4", "010-1551-2222", "pass723", "0", 0, 0,
 * 0, User.NOSEAT, 0, 0, "bronze");
 * 
 * userList.add(u); userList.add(u1); userList.add(u2); userList.add(u3);
 * userList.add(u4);
 * 
 * // return userList;
 * 
 * AdmDao ad = new AdmDao(); ad.admWrite(userList); }
 * 
 * public void infoRead() { AdmDao ad = new AdmDao(); for (int i = 0; i <
 * ad.admRead().size(); i++) { System.out.println(ad.admRead().get(i)); }
 * 
 * 
 * }
 */
