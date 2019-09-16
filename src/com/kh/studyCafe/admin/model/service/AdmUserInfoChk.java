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

		  // 날짜 오늘로 수정
	      /*개인1일권 - 시간넉넉*/long inTime1 = new Date(new GregorianCalendar(2019, 8, 16, 9, 2, 0).getTimeInMillis()).getTime();
	      /*개인1일권 - 잔여 30분*/long inTime2 = new Date(new GregorianCalendar(2019, 8, 8, 16, 11, 0).getTimeInMillis()).getTime();
	      /*개인1일권 - 잔여 5분*/long inTime3 = new Date(new GregorianCalendar(2019, 8, 16, 0, 14, 0).getTimeInMillis()).getTime();
	      /*개인1일권 - 잔여 5분*/long inTime4 = new Date(new GregorianCalendar(2019, 8, 16, 1, 15, 0).getTimeInMillis()).getTime();
	      /*개인기간권 - 시간넉넉*/long inTime5 = new Date(new GregorianCalendar(2019, 8, 16, 1, 28, 0).getTimeInMillis()).getTime();
	      /*개인기간권 - 퇴실한애*/long inTime6 = new Date(new GregorianCalendar(2019, 8, 16, 1, 28, 0).getTimeInMillis()).getTime();
	      /*그룹 1일권 - 시간넉넉*/long inTime7 = new Date(new GregorianCalendar(2019, 8, 16, 1, 28, 0).getTimeInMillis()).getTime();
	      /*그룹 1일권 - 잔여 30분*/long inTime8 = new Date(new GregorianCalendar(2019, 8, 16, 1, 28, 0).getTimeInMillis()).getTime();
				
	      long outTime1 = new Date(new GregorianCalendar(2019, 8, 16, 23, 15, 0).getTimeInMillis()).getTime();
	      long outTime2 = new Date(new GregorianCalendar(2019, 8, 16, 17, 0, 0).getTimeInMillis()).getTime();
	      long outTime3 = new Date(new GregorianCalendar(2019, 8, 16, 16, 47, 0).getTimeInMillis()).getTime();
	      long outTime4 = new Date(new GregorianCalendar(2019, 8, 16, 16, 52, 0).getTimeInMillis()).getTime();
	      long outTime5 = new Date(new GregorianCalendar(2019, 8, 18, 21, 40, 0).getTimeInMillis()).getTime();
	      long outTime6 = new Date(new GregorianCalendar(2019, 8, 21, 21, 40, 0).getTimeInMillis()).getTime();
	      long outTime7 = new Date(new GregorianCalendar(2019, 8, 16, 21, 40, 0).getTimeInMillis()).getTime();
	      long outTime8 = new Date(new GregorianCalendar(2019, 8, 16, 17, 0, 0).getTimeInMillis()).getTime();
	      
	      long currentTime = new Date().getTime();
	
	      long remainTime1 = outTime1 - currentTime;
	      long remainTime2 = outTime2 - currentTime;
	      long remainTime3 = outTime3 - currentTime;
	      long remainTime4 = outTime4 - currentTime;
	      long remainTime5 = outTime5 - currentTime;
	      long remainTime6 = outTime6 - currentTime;
	      long remainTime7 = outTime7 - currentTime;
	      long remainTime8 = outTime8 - currentTime;

	      long pointTime1 = outTime1 - inTime1;
	      long pointTime2 = outTime2 - inTime2;
	      long pointTime3 = outTime3 - inTime3;
	      long pointTime4 = outTime4 - inTime4;
	      long pointTime5 = outTime5 - inTime5;
	      long pointTime6 = outTime6 - inTime6;
	      long pointTime7 = outTime7 - inTime7;
	      long pointTime8 = outTime8 - inTime8;

	      User u = new User("서범수", "010-2453-7140", "pass12", "1", inTime1, outTime1, remainTime1, User.HOURSEAT, pointTime1, "silver");
	      User u1 = new User("허현주", "010-8674-3708", "pass12", "23", inTime2, outTime2, remainTime2, User.HOURSEAT, pointTime2, "gold");
	      User u2 = new User("조문정", "010-2544-5412", "pass12", "4", inTime3, outTime3, remainTime3, User.HOURSEAT, pointTime3, "silver");
	      User u3 = new User("이범희", "010-5674-7894", "pass12", "6", inTime4, outTime4, remainTime4, User.HOURSEAT, pointTime4, "silver");
	      User u4 = new User("안동환", "010-2146-3483", "pass12", "19", inTime5, outTime5, remainTime5, User.WEEKSEAT, pointTime5, "bronze");
	      User u5 = new User("문호승", "010-2168-1368", "pass12", "13", 0, outTime6, remainTime6, User.WEEKSEAT, pointTime6, "silver");
	      User u6 = new User("윤재영", "010-1677-0743", "pass12", "4-A", inTime7, outTime7, remainTime7, User.HOURSEAT, pointTime7, "silver");
	      User u7 = new User("문혜린", "010-1345-4378", "pass12", "6-B", inTime8, outTime8, remainTime8, User.HOURSEAT, pointTime8, "bronze");
	      User u8 = new User("오수민", "010-1567-1678", "pass12", "0", 0, 0, 0, User.NOSEAT, 0, "bronze");
	      User u9 = new User("차은우", "010-2366-9753", "pass12", "0", 0, 0, 0, User.NOSEAT, 0, "bronze");
	      User u10 = new User("신세경", "010-2778-1366", "pass12", "0", 0, 0, 0, User.NOSEAT, 0, "bronze");
	      User u11 = new User("김슬기", "010-4140-2094", "pass12", "0", 0, 0, 0, User.NOSEAT, 0, "bronze");
	      
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

