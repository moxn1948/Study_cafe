package com.kh.studyCafe.admin.model.comparator;

import java.util.Comparator;

import com.kh.studyCafe.admin.model.vo.AdmUserTable;

// 관리자 테이블에 올리는 회원 이름 오름차순 정렬
public class AscendingName implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {
		AdmUserTable cob1 = (AdmUserTable) o1; 
		AdmUserTable cob2 = (AdmUserTable) o2;
		
		return cob1.getName().compareTo(cob2.getName());
	}

}
