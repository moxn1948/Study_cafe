package com.kh.studyCafe.admin.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.kh.studyCafe.admin.model.comparator.AscendingName;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.model.vo.User;

public class AdmUserInfoChk {
	
		// 이용중인 회원 데이터 가공
	   public ArrayList<AdmUserTable> usingUserInfo(ArrayList<User> u) {
	      
	      ArrayList<User> user = new ArrayList<User>();

	      for (int i = 0; i < u.size(); i++) {
	         if (u.get(i).getInTime() != 0) {
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

	   // 전체회원에서 이용 중인 회원을 제외한 회원 데이터 가공
	   public ArrayList<AdmUserTable> AllUserInfo(ArrayList<User> u) {
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
	
	
	// 회원 데이터 입력 메소드
	public void infoWrite() {
		// 개인 1일권 - 입실
		// 개인 기간권 - 입실
		// 개인 1일권 - 입실 - 잔여시간 30분 미만
		// 그룹 1일권 - 입실
		// 그룹 1일권 - 입실 - 잔여시간 30분 미만
		// 개인 기간권 - 입실X
		// 개인 - 빈 회원

		  // 날짜 오늘로 수정
	      long inTime1 = new Date(new GregorianCalendar(2019, 8, 14, 0, 2, 0).getTimeInMillis()).getTime();
	      /*기간권-날짜수정안해도됨*/long inTime2 = new Date(new GregorianCalendar(2019, 8, 8, 0, 11, 0).getTimeInMillis()).getTime();
	      long inTime3 = new Date(new GregorianCalendar(2019, 8, 14, 0, 14, 0).getTimeInMillis()).getTime();
	      long inTime4 = new Date(new GregorianCalendar(2019, 8, 14, 1, 15, 0).getTimeInMillis()).getTime();
	      long inTime5 = new Date(new GregorianCalendar(2019, 8, 14, 1, 28, 0).getTimeInMillis()).getTime();
	
				
	      /*날짜 오늘로 수정*/long outTime1 = new Date(new GregorianCalendar(2019, 8, 14, 23, 55, 0).getTimeInMillis()).getTime();
	      /*기간권-날짜수정안해도됨*/long outTime2 = new Date(new GregorianCalendar(2019, 8, 15, 0, 0, 0).getTimeInMillis()).getTime();
	      /*잔여시간 30분 미만으로 수정*/long outTime3 = new Date(new GregorianCalendar(2019, 8, 14, 12, 40, 0).getTimeInMillis()).getTime();
	      /*날짜 오늘로 수정*/long outTime4 = new Date(new GregorianCalendar(2019, 8, 14, 23, 5, 0).getTimeInMillis()).getTime();
	      /*잔여시간 30분 미만으로 수정*/long outTime5 = new Date(new GregorianCalendar(2019, 8, 14, 16, 00, 0).getTimeInMillis()).getTime();
	      
	      long currentTime = new Date().getTime();
	
	      long remainTime1 = outTime1 - currentTime;
	      long remainTime2 = outTime2 - currentTime;
	      long remainTime3 = outTime3 - currentTime;
	      long remainTime4 = outTime4 - currentTime;
	      long remainTime5 = outTime5 - currentTime;
	      long pointTime1 = outTime1 - inTime1;
	      long pointTime2 = outTime2 - inTime2;
	      long pointTime3 = outTime3 - inTime3;
	      long pointTime4 = outTime4 - inTime4;
	      long pointTime5 = outTime5 - inTime5;
	  	
	      User u = new User("별님", "12", "12", "12", inTime1, outTime1, remainTime1, User.HOURSEAT, pointTime1, "silver");
	      User u1 = new User("달님", "010-2222-2222", "pas24", "16", inTime2, outTime2, remainTime2, User.WEEKSEAT, pointTime2, "gold");
	      User u2 = new User("햇님", "010-3333-3333", "pass323", "4", inTime3, outTime3, remainTime3, User.HOURSEAT, pointTime3, "silver");
	      User u3 = new User("팥쥐", "010-4444-4444", "pass423", "6-A", inTime4, outTime4, remainTime4, User.HOURSEAT, pointTime4, "silver");
	      User u4 = new User("콩쥐", "010-5555-5555", "pass523", "4-B", inTime5, outTime5, remainTime5, User.HOURSEAT, pointTime5, "bronze");
	      User u5 = new User("민국", "010-7777-7777", "pass723", "13", 0, outTime2, remainTime2, User.WEEKSEAT, pointTime5, "silver");
	      User u6 = new User("대한", "010-6666-6666", "pass623", "22", 0, outTime2, remainTime2, User.WEEKSEAT, pointTime5, "silver");
	      User u7 = new User("만세", "010-8888-8888", "pass83", "0", 0, 0, 0, User.NOSEAT, pointTime5, "silver");
	      User u8 = new User("백설", "010-9999-9999", "pass8213", "0", 0, 0, 0, User.NOSEAT, pointTime5, "silver");
	      User u9 = new User("라푼젤", "010-1212-1212", "pass8323", "0", 0, 0, 0, User.NOSEAT, pointTime5, "silver");
	      User u10 = new User("뮬란", "010-1313-1313", "pass8623", "0", 0, 0, 0, User.NOSEAT, pointTime5, "silver");
	      User u11 = new User("알라딘", "010-1414-1414", "pass8823", "0", 0, 0, 0, User.NOSEAT, pointTime5, "silver");
	      
	      AdmDao ad = new AdmDao();
	      ad.admWrite(u);
	      ad.admWrite(u1);
	      ad.admWrite(u2);
	      ad.admWrite(u3);
	      ad.admWrite(u4);
	      ad.admWrite(u5);
	      ad.admWrite(u6);
	      ad.admWrite(u7);
	      ad.admWrite(u8);
	      ad.admWrite(u9);
	      ad.admWrite(u10);
	      ad.admWrite(u11);
	}

}

