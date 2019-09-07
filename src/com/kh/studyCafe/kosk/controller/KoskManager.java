package com.kh.studyCafe.kosk.controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.kh.studyCafe.kosk.view.popup.KoskPasswordDoNot;
import com.kh.studyCafe.model.service.SignUpService;

public class KoskManager {
	public KoskManager() {}
	public KoskManager(ArrayList number2) { // KoskSignUp에서 정보를 받아옴
		Iterator it = (Iterator) number2.iterator();
		
		String[] value = new String[4]; // 0번부터 3번까지 순서대로 정보를 value에 저장함
		
		SignUpService ss = new SignUpService();
		ss.signupservice(value);
			BufferedWriter bw = null;
			if(ss.signupservice(value)== true) {
				
				try {
					bw = new BufferedWriter(new FileWriter("userlist.txt",true));
					bw.write(value[0]+"/");
					bw.write(value[1]+"/");
					bw.write(value[2]+"/");
					bw.write(value[3]+"\r\n");// 파일 입력하는 부분
				} catch (IOException e) {
					
					e.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			} else {
				new KoskPasswordDoNot(); // false 이면 팝업창 뜸
			}
			
		}
	public void seatManger(String seatnum) {
		BufferedWriter bw = null;
		BufferedReader br = null;
			
					try {
						br = new BufferedReader(new FileReader("userlist.txt"));
						
						bw = new BufferedWriter(new FileWriter("userlist.txt",true)); 
						//bw.write(seatnum+"\n");
						String str = null;
						str = br.readLine();
						if(str == null) {
							bw.write(seatnum);
						} else {
							bw.write("\n"+seatnum);
						}
						
						
							bw.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		System.out.println(seatnum+"번 좌석 Manager로 이동완료");
		
	}
	public ArrayList seat() {
		
		BufferedReader br = null;
		String read =null;
		ArrayList seatlist = new ArrayList();
		try {
			br = new BufferedReader(new FileReader("userlist.txt"));
			while((read = br.readLine())!= null) {
			
				seatlist.add(read);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seatlist; 
		
	}
	public int[] seatint() {
		ArrayList num = this.seat();
		Iterator it = (Iterator) num.iterator();
		int[] a = new int[num.size()];
		
		for(int i=0; i<num.size(); i++) {
			a[i] = (int) num.get(i);
		}
		
		return a;
	}
	public int a;
	public void intime(int time) {
		BufferedWriter bw = null;
		BufferedReader br = null;
			
					try {
						br = new BufferedReader(new FileReader("time.txt"));
						
						bw = new BufferedWriter(new FileWriter("time.txt")); 
						//bw.write(seatnum+"\n");
						String str = null;
						
							bw.write(time);
							bw.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		System.out.println(time+"시 선택시간 Manager로 이동완료");	
	}
	
	public int gettime() {
		BufferedReader br = null;
			
		try {
			br = new BufferedReader(new FileReader("time.txt"));
			
			a = br.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return a;
	}
	}
